package io.github.baijifeilong.blog.code.generator;

import com.google.common.base.CaseFormat;
import com.zaxxer.hikari.HikariDataSource;
import io.github.baijifeilong.sql.ScriptRunner;
import lombok.SneakyThrows;
import lombok.experimental.FieldNameConstants;
import lombok.extern.slf4j.Slf4j;
import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.codegen.GenerationTool;
import org.jooq.codegen.JavaGenerator;
import org.jooq.codegen.JavaWriter;
import org.jooq.meta.Definition;
import org.jooq.meta.TableDefinition;
import org.jooq.meta.TypedElementDefinition;
import org.jooq.meta.jaxb.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author BaiJiFeiLong@gmail.com
 */
@SpringBootApplication
@Slf4j
public class BlogCodeGeneratorApplication implements ApplicationListener<ApplicationReadyEvent> {

    @Resource
    private DataSource dataSource;

    @Resource
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BlogCodeGeneratorApplication.class, args);
    }

    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent applicationReadyEvent) {
        log.info("Initializing database ...");
        initDatabase();
        log.info("Jooq generating...");
        doJooqGeneration();
    }

    @SneakyThrows
    private void initDatabase() {
        jdbcTemplate.execute("DROP SCHEMA IF EXISTS thatcher");
        jdbcTemplate.execute("CREATE SCHEMA thatcher");
        jdbcTemplate.execute("USE thatcher");
        jdbcTemplate.execute("CREATE TABLE great_user(ID INT PRIMARY KEY AUTO_INCREMENT, username TEXT)");
        new ScriptRunner(
                dataSource.getConnection(), false, true
        ).runScript(
                new FileReader(new ClassPathResource("1.sql").getFile())
        );
    }

    @SneakyThrows
    private void doJooqGeneration() {
        HikariDataSource hikariDataSource = (HikariDataSource) dataSource;
        GenerationTool.generate(new Configuration()
                .withJdbc(new Jdbc()
                        .withUrl(hikariDataSource.getJdbcUrl())
                        .withUser(hikariDataSource.getUsername())
                        .withPassword(hikariDataSource.getPassword()))
                .withGenerator(new Generator()
                        .withName(MyJavaGenerator.class.getName())
                        .withDatabase(new Database()
                                .withSchemata(
                                        new Schema().withInputSchema("thatcher"),
                                        new Schema().withInputSchema("blog"))
                                .withExcludes(".*\\d+"))
                        .withStrategy(new Strategy()
                                .withName(MyStrategy.class.getName()))
                        .withGenerate(new Generate()
                                .withJavaTimeTypes(true))
                        .withTarget(new Target()
                                .withPackageName("io.github.baijifeilong.blog.generated.jooq")
                                .withDirectory("../blog-generated-jooq/src/main/java"))));
        Runtime.getRuntime().exec("rm create_db.log");
        Runtime.getRuntime().exec("rm create_db_error.log");
    }

    @Slf4j
    public static class MyStrategy extends DefaultGeneratorStrategy {
        private static final String[] TABLE_PREFIXES = new String[]{"wb"};
        private Pattern pattern = Pattern.compile(String.format("(%s)_(.+)", String.join("|", TABLE_PREFIXES)));

        @Override
        public String getJavaClassName(Definition definition, Mode mode) {
            String name = super.getJavaClassName(definition, mode);
            String snakeCaseName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
            Matcher matcher = pattern.matcher(snakeCaseName);
            if (!matcher.matches()) {
                return name;
            }
            String newSnakeCaseName = matcher.group(2);
            String newName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, newSnakeCaseName);
            log.info("{} => {}", name, newName);
            return newName;
        }
    }

    public static class MyJavaGenerator extends JavaGenerator {
        @Override
        protected void generateRecordGetter(TypedElementDefinition<?> column, int index, JavaWriter out) {
            super.generateRecordGetter(column, index, out);
            String camelCase = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, column.getName());
            out.print("\n    /**\n     * Generated by baijifeilong@gmail.com\n     */\n    private %s %s;\n",
                    out.ref(getJavaType(column.getType())), camelCase);
        }

        @Override
        protected void generateRecordClassJavadoc(TableDefinition table, JavaWriter out) {
            super.generateRecordClassJavadoc(table, out);
            out.println("@" + FieldNameConstants.class.getName());
        }
    }
}

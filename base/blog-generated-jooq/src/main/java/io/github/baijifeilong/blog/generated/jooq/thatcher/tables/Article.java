/*
 * This file is generated by jOOQ.
 */
package io.github.baijifeilong.blog.generated.jooq.thatcher.tables;


import io.github.baijifeilong.blog.generated.jooq.thatcher.Indexes;
import io.github.baijifeilong.blog.generated.jooq.thatcher.Keys;
import io.github.baijifeilong.blog.generated.jooq.thatcher.Thatcher;
import io.github.baijifeilong.blog.generated.jooq.thatcher.tables.records.ArticleRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Article extends TableImpl<ArticleRecord> {

    private static final long serialVersionUID = 770404175;

    /**
     * The reference instance of <code>thatcher.article</code>
     */
    public static final Article ARTICLE = new Article();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ArticleRecord> getRecordType() {
        return ArticleRecord.class;
    }

    /**
     * The column <code>thatcher.article.id</code>.
     */
    public final TableField<ArticleRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>thatcher.article.user_id</code>.
     */
    public final TableField<ArticleRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>thatcher.article.title</code>.
     */
    public final TableField<ArticleRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>thatcher.article.content</code>.
     */
    public final TableField<ArticleRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>thatcher.article.created_at</code>.
     */
    public final TableField<ArticleRecord, LocalDateTime> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>thatcher.article.updated_at</code>.
     */
    public final TableField<ArticleRecord, LocalDateTime> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>thatcher.article.deleted</code>.
     */
    public final TableField<ArticleRecord, Byte> DELETED = createField("deleted", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * Create a <code>thatcher.article</code> table reference
     */
    public Article() {
        this(DSL.name("article"), null);
    }

    /**
     * Create an aliased <code>thatcher.article</code> table reference
     */
    public Article(String alias) {
        this(DSL.name(alias), ARTICLE);
    }

    /**
     * Create an aliased <code>thatcher.article</code> table reference
     */
    public Article(Name alias) {
        this(alias, ARTICLE);
    }

    private Article(Name alias, Table<ArticleRecord> aliased) {
        this(alias, aliased, null);
    }

    private Article(Name alias, Table<ArticleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Article(Table<O> child, ForeignKey<O, ArticleRecord> key) {
        super(child, key, ARTICLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Thatcher.THATCHER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ARTICLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ArticleRecord, Integer> getIdentity() {
        return Keys.IDENTITY_ARTICLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ArticleRecord> getPrimaryKey() {
        return Keys.KEY_ARTICLE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ArticleRecord>> getKeys() {
        return Arrays.<UniqueKey<ArticleRecord>>asList(Keys.KEY_ARTICLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Article as(String alias) {
        return new Article(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Article as(Name alias) {
        return new Article(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Article rename(String name) {
        return new Article(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Article rename(Name name) {
        return new Article(name, null);
    }
}
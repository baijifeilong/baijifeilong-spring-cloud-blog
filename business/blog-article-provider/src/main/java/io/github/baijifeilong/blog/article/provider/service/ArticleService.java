package io.github.baijifeilong.blog.article.provider.service;

import io.github.baijifeilong.blog.article.api.domain.Article;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static io.github.baijifeilong.blog.generated.jooq.blog.Tables.ARTICLE;

/**
 * @author BaiJiFeiLong@gmail.com
 * @date 2019-04-24 17:17
 */
@Service
public class ArticleService {

    @Resource
    private DSLContext dslContext;

    public Article createArticle(
            int userId,
            String title,
            String content
    ) {
        return dslContext.insertInto(ARTICLE)
                .set(ARTICLE.USER_ID, userId)
                .set(ARTICLE.TITLE, title)
                .set(ARTICLE.CONTENT, content)
                .returning()
                .fetchOne()
                .into(Article.class);
    }
}

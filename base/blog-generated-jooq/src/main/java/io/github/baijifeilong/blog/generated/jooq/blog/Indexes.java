/*
 * This file is generated by jOOQ.
 */
package io.github.baijifeilong.blog.generated.jooq.blog;


import io.github.baijifeilong.blog.generated.jooq.blog.tables.Article;
import io.github.baijifeilong.blog.generated.jooq.blog.tables.User;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>blog</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index ARTICLE_PRIMARY = Indexes0.ARTICLE_PRIMARY;
    public static final Index USER_PRIMARY = Indexes0.USER_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index ARTICLE_PRIMARY = Internal.createIndex("PRIMARY", Article.ARTICLE, new OrderField[] { Article.ARTICLE.ID }, true);
        public static Index USER_PRIMARY = Internal.createIndex("PRIMARY", User.USER, new OrderField[] { User.USER.ID }, true);
    }
}
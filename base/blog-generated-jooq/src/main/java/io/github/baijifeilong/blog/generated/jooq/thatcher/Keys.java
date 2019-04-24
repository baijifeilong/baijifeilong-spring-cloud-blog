/*
 * This file is generated by jOOQ.
 */
package io.github.baijifeilong.blog.generated.jooq.thatcher;


import io.github.baijifeilong.blog.generated.jooq.thatcher.tables.Article;
import io.github.baijifeilong.blog.generated.jooq.thatcher.tables.GreatUser;
import io.github.baijifeilong.blog.generated.jooq.thatcher.tables.User;
import io.github.baijifeilong.blog.generated.jooq.thatcher.tables.records.ArticleRecord;
import io.github.baijifeilong.blog.generated.jooq.thatcher.tables.records.GreatUserRecord;
import io.github.baijifeilong.blog.generated.jooq.thatcher.tables.records.UserRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>thatcher</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<ArticleRecord, Integer> IDENTITY_ARTICLE = Identities0.IDENTITY_ARTICLE;
    public static final Identity<GreatUserRecord, Integer> IDENTITY_GREAT_USER = Identities0.IDENTITY_GREAT_USER;
    public static final Identity<UserRecord, Integer> IDENTITY_USER = Identities0.IDENTITY_USER;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ArticleRecord> KEY_ARTICLE_PRIMARY = UniqueKeys0.KEY_ARTICLE_PRIMARY;
    public static final UniqueKey<GreatUserRecord> KEY_GREAT_USER_PRIMARY = UniqueKeys0.KEY_GREAT_USER_PRIMARY;
    public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = UniqueKeys0.KEY_USER_PRIMARY;
    public static final UniqueKey<UserRecord> KEY_USER_USERNAME = UniqueKeys0.KEY_USER_USERNAME;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<ArticleRecord, Integer> IDENTITY_ARTICLE = Internal.createIdentity(Article.ARTICLE, Article.ARTICLE.ID);
        public static Identity<GreatUserRecord, Integer> IDENTITY_GREAT_USER = Internal.createIdentity(GreatUser.GREAT_USER, GreatUser.GREAT_USER.ID);
        public static Identity<UserRecord, Integer> IDENTITY_USER = Internal.createIdentity(User.USER, User.USER.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<ArticleRecord> KEY_ARTICLE_PRIMARY = Internal.createUniqueKey(Article.ARTICLE, "KEY_article_PRIMARY", Article.ARTICLE.ID);
        public static final UniqueKey<GreatUserRecord> KEY_GREAT_USER_PRIMARY = Internal.createUniqueKey(GreatUser.GREAT_USER, "KEY_great_user_PRIMARY", GreatUser.GREAT_USER.ID);
        public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = Internal.createUniqueKey(User.USER, "KEY_user_PRIMARY", User.USER.ID);
        public static final UniqueKey<UserRecord> KEY_USER_USERNAME = Internal.createUniqueKey(User.USER, "KEY_user_username", User.USER.USERNAME);
    }
}
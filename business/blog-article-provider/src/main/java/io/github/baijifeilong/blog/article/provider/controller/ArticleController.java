package io.github.baijifeilong.blog.article.provider.controller;

import io.github.baijifeilong.blog.article.api.ArticleApi;
import io.github.baijifeilong.blog.article.api.domain.Article;
import io.github.baijifeilong.blog.article.provider.service.ArticleService;
import io.github.baijifeilong.blog.user.api.UserApi;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author BaiJiFeiLong@gmail.com
 * @date 2019-04-24 17:16
 */
@RestController
public class ArticleController implements ArticleApi {

    @Resource
    private ArticleService articleService;

    @Resource
    private UserApi userApi;

    @Override
    public Article createArticle(int userId, String title, String content) {
        userApi.findUserByIdOrThrow(userId);
        return articleService.createArticle(userId, title, content);
    }
}

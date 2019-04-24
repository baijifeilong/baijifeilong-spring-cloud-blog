package io.github.baijifeilong.blog.article.api;

import io.github.baijifeilong.blog.article.api.domain.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author BaiJiFeiLong@gmail.com
 * @date 2019-04-24 17:22
 */
@FeignClient("blog-article-provider")
public interface ArticleApi {

    @RequestMapping(value = "/api/articles", method = RequestMethod.POST)
    Article createArticle(
            @RequestParam("userId") int userId,
            @RequestParam("title") String title,
            @RequestParam("content") String content
    );
}

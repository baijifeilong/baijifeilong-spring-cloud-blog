package io.github.baijifeilong.blog.article.provider;

import io.github.baijifeilong.blog.article.provider.controller.ArticleController;
import io.github.baijifeilong.blog.user.api.BlogUserApiApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;

import javax.annotation.Resource;

@SpringCloudApplication
@EnableFeignClients(basePackageClasses = BlogUserApiApplication.class)
public class BlogArticleProviderApplication implements ApplicationListener<ApplicationReadyEvent> {

    @Resource
    private ArticleController articleController;

    public static void main(String[] args) {
        SpringApplication.run(BlogArticleProviderApplication.class, args);
    }

    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent applicationReadyEvent) {
        System.out.println(articleController);
    }
}

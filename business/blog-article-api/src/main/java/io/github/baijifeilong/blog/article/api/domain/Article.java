package io.github.baijifeilong.blog.article.api.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author BaiJiFeiLong@gmail.com
 * @date 2019-04-24 17:14
 */
@Data
public class Article {

    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

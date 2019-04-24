package io.github.baijifeilong.blog.user.api.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author BaiJiFeiLong@gmail.com
 * @date 2019-04-24 14:58
 */
@Data
public class User {

    private Integer id;
    private String username;
    private String encryptedPassword;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

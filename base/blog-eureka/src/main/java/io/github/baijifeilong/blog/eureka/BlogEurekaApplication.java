package io.github.baijifeilong.blog.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringCloudApplication
@EnableEurekaServer
public class BlogEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogEurekaApplication.class, args);
    }
}

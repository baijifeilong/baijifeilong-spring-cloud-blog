package io.github.baijifeilong.blog.foundation;

import io.github.baijifeilong.blog.foundation.feign.ArticleErrorDecoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author BaiJiFeiLong@gmail.com
 * @date 2019-04-24 19:19
 */
@Configuration
@Import(ArticleErrorDecoder.class)
public class BlogFoundatonAutoConfiguration {
}

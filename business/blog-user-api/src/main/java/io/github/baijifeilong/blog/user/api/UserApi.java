package io.github.baijifeilong.blog.user.api;

import io.github.baijifeilong.blog.user.api.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author BaiJiFeiLong@gmail.com
 * @date 2019-04-24 17:06
 */
@FeignClient("blog-user-provider")
public interface UserApi {

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    User createUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    );

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    User findUserByIdOrThrow(
            @PathVariable("id") Integer id
    );
}

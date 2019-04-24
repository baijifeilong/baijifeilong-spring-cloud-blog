package io.github.baijifeilong.blog.user.provider.controller;

import io.github.baijifeilong.blog.user.api.UserApi;
import io.github.baijifeilong.blog.user.api.domain.User;
import io.github.baijifeilong.blog.user.provider.service.UserService;
import io.github.baijifeilong.foundation.web.AbstractBaseController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by BaiJiFeiLong@gmail.com at 2019-04-24 14:46
 *
 * @author bj
 */
@RestController
public class UserController extends AbstractBaseController implements UserApi {

    @Resource
    private UserService userService;

    @Override
    public User createUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        return userService.createUser(username, password);
    }

    @Override
    public User findUserByIdOrThrow(Integer id) {
        return userService.findUserByIdOrThrow(id);
    }
}

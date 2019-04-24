package io.github.baijifeilong.blog.user.provider.constant;

/**
 * @author BaiJiFeiLong@gmail.com
 * @date 2019-04-24 15:18
 */
public interface UserExceptionConstants {
    int USER_EXCEPTION = 120000;
    String USER_EXCEPTION_MESSAGE = "用户模块异常";

    int USER_ALREADY_EXIST = 120001;
    String USER_ALREADY_EXIST_MESSAGE = "用户已存在";
    String USER_ALREADY_EXIST_TEMPLATE = "用户(%s)已存在";

    int USER_NOT_EXIST = 120002;
    String USER_NOT_EXIST_MESSAGE = "用户不存在";
    String USER_NOT_EXIST_TEMPLATE = "用户(%s)不存在";
}

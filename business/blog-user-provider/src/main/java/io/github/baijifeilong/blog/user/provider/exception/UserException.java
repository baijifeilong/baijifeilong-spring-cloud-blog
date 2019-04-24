package io.github.baijifeilong.blog.user.provider.exception;

import io.github.baijifeilong.blog.user.provider.constant.UserExceptionConstants;
import io.github.baijifeilong.foundation.exception.AbstractBaseException;

/**
 * @author BaiJiFeiLong@gmail.com
 * @date 2019-04-24 15:10
 */
@SuppressWarnings("WeakerAccess")
public class UserException extends AbstractBaseException implements UserExceptionConstants {
    @Override
    public int getCode() {
        return USER_EXCEPTION;
    }

    @Override
    protected String getDefaultMessage() {
        return USER_EXCEPTION_MESSAGE;
    }

    public UserException(Throwable throwable, Object... args) {
        super(throwable, args);
    }

    public UserException(Object... args) {
        super(args);
    }
}

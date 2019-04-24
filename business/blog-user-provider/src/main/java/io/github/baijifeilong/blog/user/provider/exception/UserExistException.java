package io.github.baijifeilong.blog.user.provider.exception;

/**
 * @author BaiJiFeiLong@gmail.com
 * @date 2019-04-24 15:17
 */
@SuppressWarnings("unused")
public class UserExistException extends UserException {
    @Override
    public int getCode() {
        return USER_ALREADY_EXIST;
    }

    @Override
    protected String getDefaultMessage() {
        return USER_ALREADY_EXIST_MESSAGE;
    }

    @Override
    protected String getTemplate() {
        return USER_ALREADY_EXIST_TEMPLATE;
    }

    public UserExistException(Throwable throwable, Object... args) {
        super(throwable, args);
    }

    public UserExistException(Object... args) {
        super(args);
    }
}

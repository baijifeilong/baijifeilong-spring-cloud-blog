package io.github.baijifeilong.blog.user.provider.exception;

/**
 * @author BaiJiFeiLong@gmail.com
 * @date 2019-04-24 15:21
 */
@SuppressWarnings("unused")
public class UserNotExistException extends UserException {

    @Override
    public int getCode() {
        return USER_NOT_EXIST;
    }

    @Override
    protected String getDefaultMessage() {
        return USER_NOT_EXIST_MESSAGE;
    }

    public UserNotExistException(Throwable throwable, Object... args) {
        super(throwable, args);
    }

    public UserNotExistException(Object... args) {
        super(args);
    }

    @Override
    protected String getTemplate() {
        return USER_NOT_EXIST_TEMPLATE;
    }
}

package io.github.baijifeilong.blog.foundation.exception;

import io.github.baijifeilong.foundation.exception.AbstractBaseException;

/**
 * @author BaiJiFeiLong@gmail.com
 * @date 2019-04-24 19:20
 */
public class RpcException extends AbstractBaseException {

    private int code;

    private String methodKey;

    public RpcException(int code, String message) {
        super(message);
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}


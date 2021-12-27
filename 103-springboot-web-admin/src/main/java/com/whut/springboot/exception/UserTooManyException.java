package com.whut.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义异常
 */
@ResponseStatus(value = HttpStatus.HTTP_VERSION_NOT_SUPPORTED,reason = "用户数量太多")
public class UserTooManyException extends Exception{

    public UserTooManyException() {
        super();
    }

    public UserTooManyException(String message) {
        super(message);
    }

}

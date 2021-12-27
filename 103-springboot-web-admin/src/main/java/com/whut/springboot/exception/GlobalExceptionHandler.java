package com.whut.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理全局异常
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 处理异常的方法
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handlerMathException(Exception e){
        log.error("异常：{}",e);
        return "login"; // 视图地址
    }

}

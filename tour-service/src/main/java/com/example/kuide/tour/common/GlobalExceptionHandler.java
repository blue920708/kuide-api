package com.example.kuide.tour.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    public ApiResult<?> handleBizException(BizException ex) {
        return new ApiResult<>(ex.code());
    }

    @ExceptionHandler(Exception.class)
    public ApiResult<?> handleException(Exception ex) {
        System.out.println("Exception: " + ex.getMessage());
        return new ApiResult<>(CommonCode.FAIL);
    }
}
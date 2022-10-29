package com.example.wespotbackend.common.exception;

import com.example.wespotbackend.common.dto.ApiResult;
import com.example.wespotbackend.common.dto.Error;
import com.example.wespotbackend.common.dto.ErrorCode;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestControllerExceptionHandler {
    /**
     * 지원하지 않는 HTTP METHOD 요청한 경우
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ApiResult<Error> handleHttpRequestMethodNotSupportedException(
            final HttpRequestMethodNotSupportedException ex) {
        ErrorCode errorCode = ErrorCode.METHOD_NOT_ALLOWED;
        final Error response = Error.of(
                ex.getMessage(), errorCode.getCode(), errorCode.getStatus()
        );

        return ApiResult.failed(response);
    }

    /**
     * 서버 에러
     */
    @ExceptionHandler(Exception.class)
    protected ApiResult<Error> handleException(
            final Exception ex) {
        return ApiResult.failed(Error.of(ex.getMessage(), "code", 500));
    }
}


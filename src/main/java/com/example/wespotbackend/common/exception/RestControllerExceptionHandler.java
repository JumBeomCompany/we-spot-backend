package com.example.wespotbackend.common.exception;

import com.example.wespotbackend.common.dto.ApiResult;
import com.example.wespotbackend.common.dto.Error;
import com.example.wespotbackend.common.dto.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.wespotbackend.common.dto.ApiResult.*;

@Slf4j
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

        return failed(response);
    }

    /**
     * 애플리케이션 비즈니스 예외들
     */
    @ExceptionHandler(BusinessException.class)
    protected ApiResult<Error> handleBusinessException(
            final BusinessException ex) {
        final Error response = Error.of(ex.getMessage(), ex.getErrorCode());
        return failed(response);
    }

    /**
     * 서버 에러
     */
    @ExceptionHandler(Exception.class)
    protected ApiResult<Error> handleException(
            final Exception ex) {
        log.error(ex.getMessage());
        return failed(Error.of(ex.getMessage(), "code", 500));
    }
}


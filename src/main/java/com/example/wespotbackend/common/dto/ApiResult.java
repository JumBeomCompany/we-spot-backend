package com.example.wespotbackend.common.dto;

import lombok.Getter;

@Getter
public class ApiResult<T> {
    private final T data;
    private final Error error;

    private ApiResult(T data, Error error) {
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResult<T> succeed(T data) {
        return new ApiResult<>(data, null);
    }

    public static <T> ApiResult<T> failed(Error errorResult) {
        return new ApiResult<>(null, errorResult);
    }
}

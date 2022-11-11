package com.example.wespotbackend.common.dto;

import lombok.Getter;

@Getter
public class Error {
    private final String message;
    private final String code;
    private final int status;

    private Error(String message, String code, int status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public static Error from(final ErrorCode errorCode) {
        return new Error(errorCode.getMessage(), errorCode.getCode(), errorCode.getStatus());
    }

    public static Error of(String message, String code, int status) {
        return new Error(message, code, status);
    }

    public static Error of(String message, ErrorCode errorCode) {
        return new Error(message, errorCode.getCode(), errorCode.getStatus());
    }
}


package com.example.wespotbackend.common.exception;

import com.example.wespotbackend.common.dto.ErrorCode;

public class NotExistsUserException extends BusinessException {
    public NotExistsUserException() {
        super(ErrorCode.NOT_EXISTS_USER);
    }

    public NotExistsUserException(String message) {
        super(message, ErrorCode.NOT_EXISTS_USER);
    }
}

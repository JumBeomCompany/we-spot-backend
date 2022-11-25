package com.example.wespotbackend.common.exception;

import com.example.wespotbackend.common.dto.ErrorCode;

public class NotExistsFeedException extends BusinessException {
    public NotExistsFeedException() {
        super(ErrorCode.NOT_EXISTS_FEED);
    }

    public NotExistsFeedException(String message) {
        super(message, ErrorCode.NOT_EXISTS_FEED);
    }
}

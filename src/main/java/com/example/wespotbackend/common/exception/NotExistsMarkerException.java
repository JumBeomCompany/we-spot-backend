package com.example.wespotbackend.common.exception;

import com.example.wespotbackend.common.dto.ErrorCode;

public class NotExistsMarkerException extends BusinessException {
    public NotExistsMarkerException() {
        super(ErrorCode.NOT_EXISTS_MARKER);
    }

    public NotExistsMarkerException(String message) {
        super(message, ErrorCode.NOT_EXISTS_MARKER);
    }
}

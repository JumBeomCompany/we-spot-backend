package com.example.wespotbackend.common.dto;

import lombok.Getter;

@Getter
public enum ErrorCode {
    TEST_CODE(200, "T001", "테스트 에러 코드."),
    METHOD_NOT_ALLOWED(405, "E001", "지원하는 않는 요청 메서드 입니다."),

    NOT_EXISTS_USER(400, "B001", "존재하지 않는 사용자 입니다.");

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
package com.example.wespotbackend.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResponse {
    private Long id;

    private String email;

    private String name;

    @Builder
    private UserResponse(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
}

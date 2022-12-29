package com.example.wespotbackend.feed.dto;

import com.example.wespotbackend.user.User;
import com.example.wespotbackend.user.dto.UserResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class FeedResponse {
    private Long id;

    @JsonIgnore
    private User user;

    @JsonProperty(value = "user")
    private UserResponse userResponse;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @QueryProjection
    @Builder
    public FeedResponse(Long id, UserResponse userResponse, String title, String content, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.userResponse = userResponse;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}

package com.example.wespotbackend.marker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MarkerResponse {
    private Long id;

    @Builder
    private MarkerResponse(Long id) {
        this.id = id;
    }
}

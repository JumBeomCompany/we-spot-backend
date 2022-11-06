package com.example.wespotbackend.marker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static com.google.common.base.Preconditions.checkArgument;

@Getter
@Setter
@ToString
public class MarkerRequest {
    private Double latitude; // 위도, y축

    private Double longitude; // 경도, x축

    private Long userId;

    private String feedTitle;

    private String feedContent;

    @Builder
    public MarkerRequest(Double latitude, Double longitude, Long userId, String feedTitle, String feedContent) {
        checkArgument(!isSetLocation(), "필수 매개변수 누락 (위도, 경도)");
        checkArgument(userId != null, "사용자 id 누락");
        checkArgument(feedTitle != null && !feedTitle.isBlank(), "필수 매개변수 누락 (피드 제목)");
        this.latitude = latitude;
        this.longitude = longitude;
        this.userId = userId;
        this.feedTitle = feedTitle;
        this.feedContent = feedContent;
    }

    private boolean isSetLocation() {
        return latitude != null && longitude != null;
    }
}

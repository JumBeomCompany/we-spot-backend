package com.example.wespotbackend.marker.dto;

import com.example.wespotbackend.marker.Marker;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MarkerResponse {
    private Long id;

    private Double latitude;

    private Double longitude;

    private String feedTitle;

    private String feedContent;

    @Builder
    private MarkerResponse(Long id, Double latitude, Double longitude, String feedTitle, String feedContent) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.feedTitle = feedTitle;
        this.feedContent = feedContent;
    }

    public MarkerResponse(Marker marker) {
        this.id = marker.getId();
        this.latitude = marker.getMakerLocation().getLatitude();
        this.longitude = marker.getMakerLocation().getLongitude();
        this.feedTitle = marker.getFeed().getTitle();
        this.feedContent = marker.getFeed().getContent();
    }
}

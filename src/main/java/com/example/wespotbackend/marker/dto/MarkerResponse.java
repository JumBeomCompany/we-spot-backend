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

    @Builder
    private MarkerResponse(Long id, Double latitude, Double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public MarkerResponse(Marker marker) {
        this.id = marker.getId();
        this.latitude = marker.getMakerLocation().getLatitude();
        this.longitude = marker.getMakerLocation().getLongitude();
    }
}

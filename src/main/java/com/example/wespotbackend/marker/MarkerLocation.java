package com.example.wespotbackend.marker;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class MarkerLocation {
    @Column(name = "latitude")
    private Double latitude; // 위도, y축

    @Column(name = "longitude")
    private Double longitude; // 경도, x축

    private MarkerLocation(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    protected MarkerLocation() {
        /* empty */
    }

    public static MarkerLocation of(Double latitude, Double longitude) {
        return new MarkerLocation(latitude, longitude);
    }
}

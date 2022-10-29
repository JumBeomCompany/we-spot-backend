package com.example.wespotbackend.maker;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class MarkerLocation {
    @Column(name = "m_latitude")
    private Float markerLatitude; // 위도, y축

    @Column(name = "m_longitude")
    private Float markerLongitude; // 경도, x축

    private MarkerLocation(Float latitude, Float longitude) {
        this.markerLatitude = latitude;
        this.markerLongitude = longitude;
    }

    protected MarkerLocation() {
        /* empty */
    }

    public static MarkerLocation of(Float latitude, Float longitude) {
        return new MarkerLocation(latitude, longitude);
    }
}

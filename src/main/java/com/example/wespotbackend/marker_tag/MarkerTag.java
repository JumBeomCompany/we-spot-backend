package com.example.wespotbackend.marker_tag;

import com.example.wespotbackend.maker.Marker;
import com.example.wespotbackend.tag.Tag;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "Marker_tag")
public class MarkerTag {
    @Id
    @Column(name = "mt_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer markerTagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "m_id")
    private Marker marker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_id")
    private Tag tag;

    @Builder
    private MarkerTag(Integer markerTagId, Marker marker, Tag tag) {
        this.markerTagId = markerTagId;
        this.marker = marker;
        this.tag = tag;
    }

    protected MarkerTag() {
        /* empty */
    }
}

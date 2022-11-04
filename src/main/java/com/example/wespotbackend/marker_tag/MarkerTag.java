package com.example.wespotbackend.marker_tag;

import com.example.wespotbackend.marker.Marker;
import com.example.wespotbackend.model.BaseEntity;
import com.example.wespotbackend.tag.Tag;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "Marker_tag")
public class MarkerTag extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "marker_id")
    private Marker marker;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Builder
    private MarkerTag(Long id, Marker marker, Tag tag) {
        this.id = id;
        this.marker = marker;
        this.tag = tag;
    }

    protected MarkerTag() {
        /* empty */
    }
}

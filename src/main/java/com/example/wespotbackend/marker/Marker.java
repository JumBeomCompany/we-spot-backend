package com.example.wespotbackend.marker;

import com.example.wespotbackend.feed.Feed;
import com.example.wespotbackend.model.BaseEntity;
import com.example.wespotbackend.user.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "Marker")
public class Marker extends BaseEntity {
    @Id
    @Column(name = "m_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer markerId;

    @OneToOne
    @JoinColumn(name = "f_id")
    private Feed feedId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "us_id")
    private User user;

    @Embedded
    private MarkerLocation makerLocation;

    @Builder
    public Marker(Integer markerId, Feed feedId, User user, MarkerLocation makerLocation) {
        this.markerId = markerId;
        this.feedId = feedId;
        this.user = user;
        this.makerLocation = makerLocation;
    }

    protected Marker() {
        /* empty */
    }
}

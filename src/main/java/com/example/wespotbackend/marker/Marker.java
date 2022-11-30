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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Embedded
    private MarkerLocation makerLocation;

    @Builder
    public Marker(Long id, Feed feed, User user, MarkerLocation makerLocation) {
        this.id = id;
        this.feed = feed;
        this.user = user;
        this.makerLocation = makerLocation;
    }

    protected Marker() {
        /* empty */
    }
}

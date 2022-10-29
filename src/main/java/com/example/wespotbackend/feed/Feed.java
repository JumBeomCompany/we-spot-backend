package com.example.wespotbackend.feed;

import com.example.wespotbackend.model.BaseEntity;
import com.example.wespotbackend.user.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "Feed")
public class Feed extends BaseEntity {
    @Id
    @Column(name = "f_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "us_id")
    private User user;

    @Column(name = "f_title")
    private String feedTitle;

    @Column(name = "f_content", columnDefinition = "LONGTEXT")
    private String feedContent;

    @Builder
    private Feed(Long feedId, User user, String feedTitle, String feedContent) {
        this.feedId = feedId;
        this.user = user;
        this.feedTitle = feedTitle;
        this.feedContent = feedContent;
    }

    protected Feed() {
        /* empty */
    }
}

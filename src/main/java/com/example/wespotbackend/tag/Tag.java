package com.example.wespotbackend.tag;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "Tag")
public class Tag {
    @Id
    @Column(name = "t_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;

    @Column(name = "t_name")
    private String tagName;

    @Builder
    private Tag(Integer tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }

    protected Tag() {
        /* empty */
    }
}

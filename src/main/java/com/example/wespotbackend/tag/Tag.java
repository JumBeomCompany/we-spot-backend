package com.example.wespotbackend.tag;

import com.example.wespotbackend.model.BaseEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "Tag")
public class Tag extends BaseEntity {
    @Id
    @Column(name = "t_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(name = "t_name")
    private String tagName;

    @Builder
    private Tag(Long tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }

    protected Tag() {
        /* empty */
    }
}

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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Builder
    private Tag(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    protected Tag() {
        /* empty */
    }
}

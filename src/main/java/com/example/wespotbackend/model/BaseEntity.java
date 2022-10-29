package com.example.wespotbackend.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity implements Serializable {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreatedDate
    @Column(updatable = false, name = "created_at")
    private LocalDate createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDate modifiedAt;
}

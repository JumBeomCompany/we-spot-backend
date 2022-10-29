package com.example.wespotbackend.user;

import com.example.wespotbackend.model.BaseEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "Users")
public class User extends BaseEntity {
    @Id
    @Column(name = "us_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "us_email")
    private String userEmail;

    @Column(name = "us_name")
    private String userName;

    @Column(name = "us_passwd")
    private String userPasswd;

    @Builder
    private User(Long userId, String userEmail, String userName, String userPasswd) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPasswd = userPasswd;
    }

    protected User() {
        /* empty */
    }
}

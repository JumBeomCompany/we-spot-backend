package com.example.wespotbackend.user;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "us_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "us_email")
    private String userEmail;

    @Column(name = "us_name")
    private String userName;

    @Column(name = "us_passwd")
    private String userPasswd;

    @Builder
    private User(Integer userId, String userEmail, String userName, String userPasswd) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPasswd = userPasswd;
    }

    protected User() {
        /* empty */
    }
}

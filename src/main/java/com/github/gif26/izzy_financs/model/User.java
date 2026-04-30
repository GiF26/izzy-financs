package com.github.gif26.izzy_financs.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private LocalDateTime created_at;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.created_at = LocalDateTime.now();
    }
    public User(){
    }

//    id BIGINT AUTO_INCREMENT PRIMARY KEY,
//    name VARCHAR(255) NOT NULL,
//    username VARCHAR(50) NOT NULL UNIQUE,
//    password VARCHAR(255) NOT NULL,
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
}

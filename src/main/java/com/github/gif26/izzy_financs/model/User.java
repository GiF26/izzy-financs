package com.github.gif26.izzy_financs.model;

import com.github.gif26.izzy_financs.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

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

    @Column(updatable = false, name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    public User(UserDTO dto) {
        this.name = dto.name();
        this.username = dto.username();
        this.password = dto.password();
    }
    public User(){
    }
}

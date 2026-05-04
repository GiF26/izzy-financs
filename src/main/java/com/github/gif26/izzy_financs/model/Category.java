package com.github.gif26.izzy_financs.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    public Category(String description) {
        this.description = description;
    }

    public Category(String description, User userId) {
        this.description = description;
        this.userId = userId;
    }

    public Category() {
    }
}

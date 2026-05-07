package com.github.gif26.izzy_financs.model;

import com.github.gif26.izzy_financs.dto.AccountDTO;
import com.github.gif26.izzy_financs.model.enums.AccountTypeEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.ORDINAL)
    private AccountTypeEnum accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(updatable = false, name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Account(User user, AccountDTO dto) {
        this.description = dto.description();
        this.accountType = AccountTypeEnum.fromValue(dto.accountType());
        this.user = user;
    }

    public Account() {
    }
}

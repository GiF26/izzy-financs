package com.github.gif26.izzy_financs.model;

import com.github.gif26.izzy_financs.dto.transaction.CreateTransaction;
import com.github.gif26.izzy_financs.model.enums.TransactionTypeEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Enumerated(EnumType.ORDINAL)
    @Column(name= "transaction_type")
    private TransactionTypeEnum type;

    private Double amount;
    private String description;

    @Column(updatable = false, name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Transaction(CreateTransaction dto, Account account, Category category) {
        this.account = account;
        this.category = category;
        this.type = TransactionTypeEnum.valueOf(dto.transactionType());
        this.amount = dto.amount();
        this.description = dto.description();
    }

    public Transaction() {}
}

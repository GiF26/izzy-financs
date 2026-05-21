package com.github.gif26.izzy_financs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "recurring_transactions")
public class RecurringTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "category_id") // Ajustado
    private Category category;

    @Column(name = "transaction_type")
    private int transactionType;

    private String description;
    private BigDecimal amount;

    @Column(name = "due_day")
    private int dueDay;

    @Column(name = "current_installment")
    private Integer currentInstallment; // Ajustado para Integer

    @Column(name = "total_installments")
    private Integer totalInstallments; // Ajustado para Integer

    private int frequency; // Mude para Enum no futuro se quiser dar um bónus de qualidade!

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
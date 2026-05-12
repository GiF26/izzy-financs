package com.github.gif26.izzy_financs.repository;

import com.github.gif26.izzy_financs.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t " +
            "FROM Transaction t " +
            "JOIN t.account a " +
            "WHERE a.user.id = :userId")
    List<Transaction> findTransactionsByUser(Long userId);

    @Query("SELECT t " +
            "FROM Transaction t " +
            "JOIN t.account a " +
            "WHERE a.user.id = :userId " +
            "AND t.id = :transactionId")
    Transaction findTransactionByTransactionIdAndUserId(long transactionId, long userId);

    @Query("UPDATE Transaction t " +
            "SET T.account.id = :accountId, T.category.id = :categoryId, T.description = :description, T.type = :type, T.amount = :amount " +
            "WHERE t.account.user.id = :userId " +
            "AND t.id = :transactionId")
    void updateTransaction(long accountId, long categoryId, String description, int type, double amount, long userId, long transactionId);
}

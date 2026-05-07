package com.github.gif26.izzy_financs.repository;

import com.github.gif26.izzy_financs.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t " +
            "FROM Transaction t " +
            "JOIN Transaction.account a " +
            "WHERE a.user.id = :userId")
    List<Transaction> findTransactionsByUser(long userId);
}

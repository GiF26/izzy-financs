package com.github.gif26.izzy_financs.repository;

import com.github.gif26.izzy_financs.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t " +
            "FROM Transaction t " +
            "WHERE t.account.user.id = :userId")
    List<Transaction> listAllTransactions(@Param("userId") long userId);
}

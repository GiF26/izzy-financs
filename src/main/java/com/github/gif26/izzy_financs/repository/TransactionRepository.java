package com.github.gif26.izzy_financs.repository;

import com.github.gif26.izzy_financs.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

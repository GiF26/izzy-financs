package com.github.gif26.izzy_financs.controller;

import com.github.gif26.izzy_financs.dto.TransactionDTO;
import com.github.gif26.izzy_financs.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/{userId}/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionDTO> createTransaction(@PathVariable long userId,
                                                           @RequestBody TransactionDTO transactionDTO) {
        TransactionDTO transaction = transactionService.createTransaction(userId, transactionDTO);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getTransactions(@PathVariable long userId) {
        List<TransactionDTO> transactions = transactionService.listTransactions(userId);
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }


}

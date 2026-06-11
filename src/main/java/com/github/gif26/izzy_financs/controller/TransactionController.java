package com.github.gif26.izzy_financs.controller;

import com.github.gif26.izzy_financs.dto.transaction.CreateTransactionDTO;
import com.github.gif26.izzy_financs.dto.transaction.TransactionResponseDTO;
import com.github.gif26.izzy_financs.dto.transaction.UpdateTransactionDTO;
import com.github.gif26.izzy_financs.service.TransactionService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/{userId}/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> createTransaction(@PathVariable long userId,
                                                  @RequestBody CreateTransactionDTO dto) {

        transactionService.createTransaction(userId, dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateTransaction(@PathVariable long userId,
                                                  @RequestBody UpdateTransactionDTO dto) {
        transactionService.updateTransaction(userId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTransaction(@PathVariable long userId,
                                                  @RequestParam("id") long transactionId) {
        transactionService.deleteTransaction(userId, transactionId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> getTransactions(@PathVariable long userId) {
        List<TransactionResponseDTO> responses = transactionService.listAllTransactions(userId);
        return ResponseEntity.ok().body(responses);
    }
}

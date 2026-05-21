package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.dto.transaction.CreateTransactionDTO;
import com.github.gif26.izzy_financs.dto.transaction.TransactionResponseDTO;
import com.github.gif26.izzy_financs.model.Account;
import com.github.gif26.izzy_financs.model.Category;
import com.github.gif26.izzy_financs.model.Transaction;
import com.github.gif26.izzy_financs.model.enums.TransactionTypeEnum;
import com.github.gif26.izzy_financs.repository.AccountRepository;
import com.github.gif26.izzy_financs.repository.CategoryRepository;
import com.github.gif26.izzy_financs.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void createTransaction(long userId, CreateTransactionDTO dto) {
        Account account = accountRepository.findByUserIdAndId(userId, dto.idAccount());
        Category category = categoryRepository.findByUserIdAndSequenceId(userId, dto.idSequenceCategory());
        Transaction transaction = new Transaction(dto, account, category);
        transactionRepository.save(transaction);
    }

    public List<TransactionResponseDTO> listAllTransactions(long userId) {
        return transactionRepository.listAllTransactions(userId)
                .stream().map(t -> new TransactionResponseDTO(t.getId(),
                        t.getAccount().getId(), t.getAccount().getDescription(),
                        t.getCategory().getSequenceId(), t.getCategory().getDescription(),
                        t.getType().getValue(), String.valueOf(TransactionTypeEnum.valueOf(t.getType().getValue())),
                        t.getDescription(), t.getAmount()))
                .toList();
    }
}

package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.dto.TransactionDTO;
import com.github.gif26.izzy_financs.model.Account;
import com.github.gif26.izzy_financs.model.Category;
import com.github.gif26.izzy_financs.model.Transaction;
import com.github.gif26.izzy_financs.model.User;
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

    public TransactionDTO createTransaction(long userId, TransactionDTO transactionDTO) {
        Account account = accountRepository.findAccountByUserIdAndId(userId, transactionDTO.accountId());
        Category category = categoryRepository.findByIdAndIdUser(transactionDTO.categoryId(), userId);

        transactionRepository.save(new Transaction(transactionDTO, account, category));
        return transactionDTO;
    }


    public List<TransactionDTO> listTransactions(long userId) {
        List<TransactionDTO> transactions = transactionRepository.findTransactionsByUser(userId)
                .stream().map(t -> new TransactionDTO(t.getId(), t.getAccount().getId(), t.getCategory().getId(),
                        TransactionTypeEnum.valueOf(t.getType()), t.getAmount(), t.getDescription()))
                .toList();
        return transactions;
    }
}

package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.dto.AccountDTO;
import com.github.gif26.izzy_financs.model.Account;
import com.github.gif26.izzy_financs.model.User;
import com.github.gif26.izzy_financs.model.enums.AccountTypeEnum;
import com.github.gif26.izzy_financs.repository.AccountRepository;
import com.github.gif26.izzy_financs.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    public AccountDTO createAccount(Long userId, AccountDTO accountDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        accountRepository.save(new Account(user, accountDTO));
        return accountDTO;
    }

    @Transactional
    public void editAccount(Long userId, AccountDTO dto) {
        Account account = accountRepository.findById(dto.id())
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));

        accountRepository.editAccount(userId, dto.id(), dto.description(),AccountTypeEnum.fromValue(dto.accountType()));
    }

    public List<AccountDTO> listAllAccounts(long userId) {
        return accountRepository.findAccountsByUserId(userId)
                .stream()
                .map(a -> new AccountDTO(a.getId(), a.getDescription(), AccountTypeEnum.fromEnum(a.getAccountType())))
                .toList();
    }

    @Transactional
    public void deleteAccount(Long userId, Long accountId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        accountRepository.deleteAccountByUserAndId(user, accountId);
    }
}

package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.dto.account.AccountResponseDTO;
import com.github.gif26.izzy_financs.dto.account.CreateAccountDTO;
import com.github.gif26.izzy_financs.dto.account.UpdateAccountDTO;
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

    public void createAccount(Long userId, CreateAccountDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        accountRepository.save(new Account(user, dto));
    }

    @Transactional
    public void updateAccount(Long userId, UpdateAccountDTO dto) {
        accountRepository.updateAccount(userId, dto.id(), dto.description(), AccountTypeEnum.fromValue(dto.accountType()));
    }

    @Transactional
    public void deleteAccount(Long userId, Long accountId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        accountRepository.deleteAccountByUserAndId(user, accountId);
    }

    public List<AccountResponseDTO> listAllAccounts(long userId) {
        return accountRepository.findAccountsByUserId(userId)
                .stream()
                .map(a -> new AccountResponseDTO(a.getId(), a.getDescription(), AccountTypeEnum.fromEnum(a.getAccountType())))
                .toList();
    }
}

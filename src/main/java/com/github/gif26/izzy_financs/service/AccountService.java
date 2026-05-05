package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.dto.AccountDTO;
import com.github.gif26.izzy_financs.repository.AccountRepository;
import com.github.gif26.izzy_financs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    public void createAccount(Long userId, AccountDTO accountDTO) {

    }

}

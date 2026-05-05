package com.github.gif26.izzy_financs.controller;

import com.github.gif26.izzy_financs.dto.AccountDTO;
import com.github.gif26.izzy_financs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users/{userId}/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<String> createAccount(@PathVariable Long userId,
                                                 @RequestBody AccountDTO dto) {
        accountService.createAccount(userId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Account created successfully");
    }
}

package com.github.gif26.izzy_financs.controller;

import com.github.gif26.izzy_financs.dto.AccountDTO;
import com.github.gif26.izzy_financs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/{userId}/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@PathVariable Long userId,
                                                    @RequestBody AccountDTO dto) {
        AccountDTO account = accountService.createAccount(userId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @PutMapping
    public ResponseEntity<String> editAccount (@PathVariable Long userId,
                                               @RequestBody AccountDTO dto) {
        accountService.editAccount(userId, dto);
        return ResponseEntity.status(HttpStatus.OK).body("Conta editada com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> listAllAccounts(@PathVariable Long userId) {
        List<AccountDTO> accounts = accountService.listAllAccounts(userId);
        return ResponseEntity.status(HttpStatus.OK).body(accounts);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAccount(@PathVariable Long userId,
                                                @RequestParam Long accountId) {
        accountService.deleteAccount(userId, accountId);
        return ResponseEntity.status(HttpStatus.OK).body("Conta deletada com sucesso");

    }
}

//package com.github.gif26.izzy_financs.controller;
//
//import com.github.gif26.izzy_financs.dto.account.AccountResponseDTO;
//import com.github.gif26.izzy_financs.dto.account.CreateAccountDTO;
//import com.github.gif26.izzy_financs.dto.account.UpdateAccountDTO;
//import com.github.gif26.izzy_financs.service.AccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/users/{userId}/accounts")
//public class AccountController {
//
//    @Autowired
//    private AccountService accountService;
//
//    @PostMapping
//    public ResponseEntity<Void> createAccount(@PathVariable Long userId,
//                                                    @RequestBody CreateAccountDTO dto) {
//        accountService.createAccount(userId, dto);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//
//    @PutMapping
//    public ResponseEntity<String> editAccount (@PathVariable Long userId,
//                                               @RequestBody UpdateAccountDTO dto) {
//        accountService.updateAccount(userId, dto);
//        return ResponseEntity.status(HttpStatus.OK).body("Conta editada com sucesso");
//    }
//
//    @DeleteMapping
//    public ResponseEntity<String> deleteAccount(@PathVariable Long userId,
//                                                @RequestParam Long accountId) {
//        accountService.deleteAccount(userId, accountId);
//        return ResponseEntity.status(HttpStatus.OK).body("Conta deletada com sucesso");
//
//    }
//
//    @GetMapping
//    public ResponseEntity<List<AccountResponseDTO>> listAllAccounts(@PathVariable Long userId) {
//        List<AccountResponseDTO> response = accountService.listAllAccounts(userId);
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }
//}

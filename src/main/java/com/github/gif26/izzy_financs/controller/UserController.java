package com.github.gif26.izzy_financs.controller;

import com.github.gif26.izzy_financs.dto.user.CreateUserDTO;
import com.github.gif26.izzy_financs.dto.user.UserResponseDTO;
import com.github.gif26.izzy_financs.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody CreateUserDTO userDTO) {
        UserResponseDTO response = userService.registerUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

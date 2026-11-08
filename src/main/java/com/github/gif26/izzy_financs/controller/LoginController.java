package com.github.gif26.izzy_financs.controller;

import com.github.gif26.izzy_financs.dto.request.LoginRequestDTO;
import com.github.gif26.izzy_financs.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("loginRequestDTO", new LoginRequestDTO(null,null));
        return "login";
    }

    @PostMapping("/login")
    public String authLogin(@Valid @ModelAttribute LoginRequestDTO loginRequestDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "login";
        }
        if(service.login(loginRequestDTO)){
            return "login";
        }
        return "redirect:/dashboard";
    }
}
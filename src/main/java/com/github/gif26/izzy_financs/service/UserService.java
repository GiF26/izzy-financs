package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.dto.UserDTO;
import com.github.gif26.izzy_financs.model.User;
import com.github.gif26.izzy_financs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryService categoryService;

    public void registerUser(UserDTO dto) {
        User newUser = new User(dto);
        userRepository.save(newUser);
        categoryService.createCategoriesDefault(newUser);
    }
}

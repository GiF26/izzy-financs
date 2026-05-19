package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.dto.user.CreateUserDTO;
import com.github.gif26.izzy_financs.dto.user.UserResponseDTO;
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

    public UserResponseDTO registerUser(CreateUserDTO dto) {
        User newUser = new User(dto);
        userRepository.save(newUser);
        categoryService.createCategoriesDefault(newUser);
        return new UserResponseDTO(newUser.getId(), newUser.getName(), newUser.getUsername());
    }
}

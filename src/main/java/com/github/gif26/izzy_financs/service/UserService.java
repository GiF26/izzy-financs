package com.github.gif26.izzy_financs.service;

import com.github.gif26.izzy_financs.dto.request.LoginRequestDTO;
import com.github.gif26.izzy_financs.dto.request.UserRequestDTO;
import com.github.gif26.izzy_financs.infra.exception.ValidationsExceptions;
import com.github.gif26.izzy_financs.model.User;
import com.github.gif26.izzy_financs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void create(UserRequestDTO dto) {
        User user = new User(dto);
        repository.save(user);
    }

    public boolean login(LoginRequestDTO dto) {
        User user = repository.findByEmailAndPassword(dto.email(), dto.password());
        return user != null;
    }


}

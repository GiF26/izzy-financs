package com.github.gif26.izzy_financs.repository;

import com.github.gif26.izzy_financs.model.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}

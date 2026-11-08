package com.github.gif26.izzy_financs.repository;

import com.github.gif26.izzy_financs.model.Category;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByIdAndUserId(@NotNull(message = "Id categoria invalido")
                               Long id, @NotNull(message = "Id usuario invalido") Long userId);
}

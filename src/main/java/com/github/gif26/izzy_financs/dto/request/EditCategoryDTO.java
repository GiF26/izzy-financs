package com.github.gif26.izzy_financs.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EditCategoryDTO(@NotNull(message = "Id categoria invalido") Long id,
                              @NotNull(message = "Id usuario invalido") Long userId,
                              @NotBlank(message = "titulo em branco") String title,
                              boolean active) {
}

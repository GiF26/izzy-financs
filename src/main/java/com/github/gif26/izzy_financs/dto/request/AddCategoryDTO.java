package com.github.gif26.izzy_financs.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddCategoryDTO(@NotBlank(message = "O titulo da descricao nao pode ser vazio")
                             String title,
                             @NotNull(message = "id do usuario invalido") long userId) {
}

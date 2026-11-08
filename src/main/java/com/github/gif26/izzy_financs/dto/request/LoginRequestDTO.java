package com.github.gif26.izzy_financs.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(@NotBlank(message = "email nao pode ser vazio")
                              String email,
                              @NotBlank(message = "senha nao pode ser vazio")
                              String password) {
}

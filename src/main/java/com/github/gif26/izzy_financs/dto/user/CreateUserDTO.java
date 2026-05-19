package com.github.gif26.izzy_financs.dto.user;

import jakarta.validation.constraints.NotBlank;

public record CreateUserDTO(@NotBlank String name, @NotBlank String username, @NotBlank String password) {
}

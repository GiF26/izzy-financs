package com.github.gif26.izzy_financs.dto;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(@NotBlank String name, @NotBlank String username, @NotBlank String password) {
}

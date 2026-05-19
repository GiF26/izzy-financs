package com.github.gif26.izzy_financs.dto.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAccountDTO(@NotBlank String description, @NotNull int accountType) {
}

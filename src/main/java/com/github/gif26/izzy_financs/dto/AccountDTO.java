package com.github.gif26.izzy_financs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AccountDTO(@NotBlank String description, @NotNull int accountType) {
}

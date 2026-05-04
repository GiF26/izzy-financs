package com.github.gif26.izzy_financs.dto;

import com.github.gif26.izzy_financs.model.User;
import jakarta.validation.constraints.NotBlank;

public record CategoryDTO(@NotBlank String description, User userId) {
}

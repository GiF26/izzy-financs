package com.github.gif26.izzy_financs.dto.category;

import jakarta.validation.constraints.NotBlank;

public record CreateCategoryDTO(@NotBlank String description) {
}

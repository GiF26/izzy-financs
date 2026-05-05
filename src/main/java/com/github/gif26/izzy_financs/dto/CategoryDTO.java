package com.github.gif26.izzy_financs.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryDTO(Long idSequence, @NotBlank String description) {
}

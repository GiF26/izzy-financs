package com.github.gif26.izzy_financs.dto.transaction;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateTransactionDTO(@NotNull LocalDate date,
                                   @NotNull long idAccount,
                                   @NotNull long idSequenceCategory,
                                   @NotNull int transactionType,
                                   @NotBlank String description,
                                   @NotNull double amount) {
}

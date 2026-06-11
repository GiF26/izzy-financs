package com.github.gif26.izzy_financs.dto.transaction;

import java.time.LocalDate;

public record UpdateTransactionDTO(long id,
                                   LocalDate date,
                                   long idAccount,
                                   long idSequenceCategory,
                                   int transactionType,
                                   String description,
                                   double amount) {
}

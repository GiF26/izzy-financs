package com.github.gif26.izzy_financs.dto.transaction;

import java.time.LocalDate;

public record TransactionResponseDTO(long id,
                                     LocalDate date,
                                     long idAccount,
                                     String descriptionAccount,
                                     long idSequenceCategory,
                                     String descriptionCategory,
                                     int transactionType,
                                     String transactionDescription,
                                     String description,
                                     double amount) {
}

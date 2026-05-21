package com.github.gif26.izzy_financs.dto.transaction;

public record TransactionResponseDTO(long id,
                                     long idAccount,
                                     String descriptionAccount,
                                     long idSequenceCategory,
                                     String descriptionCategory,
                                     int transactionType,
                                     String transactionDescription,
                                     String description,
                                     double amount) {
}

package com.github.gif26.izzy_financs.dto;

public record TransactionDTO(long id,
                             long accountId,
                             long categoryId,
                             int type,
                             double amount,
                             String description) {
}

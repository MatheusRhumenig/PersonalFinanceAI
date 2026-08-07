package com.matheusfonseca.personal_financial_ai.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.matheusfonseca.personal_financial_ai.entity.enums.TransactionType;

// DTO (Data Transfer Object) para representar os dados de uma transação retornados em uma resposta HTTP
public record TransactionResponseDTO(
    Long id,
    String description,
    BigDecimal amount,
    TransactionType type,
    LocalDate date,
    Long userId,
    Long categoryId
) {}

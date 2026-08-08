package com.matheusfonseca.personal_financial_ai.dto;

import com.matheusfonseca.personal_financial_ai.entity.enums.TransactionType;

// DTO = Estrutura do dados no corpo da resposta
// DTO para resposta de criação de categoria
public record CategoryResponseDTO(
    Long id,
    String name,
    TransactionType type
) {}

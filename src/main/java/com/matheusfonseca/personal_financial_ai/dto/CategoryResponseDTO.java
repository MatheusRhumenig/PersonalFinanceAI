package com.matheusfonseca.personal_financial_ai.dto;

// DTO = Estrutura do dados no corpo da resposta
// DTO para resposta de criação de categoria
public record CategoryResponseDTO(
    Long id,
    String name,
    String type
) {}

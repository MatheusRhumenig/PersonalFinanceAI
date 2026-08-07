package com.matheusfonseca.personal_financial_ai.dto;

// DTO = Estrutura do dados no corpo da resposta
// DTO para resposta de criação de usuário
public record UserResponseDTO(     
    Long id,
    String name,
    String email) {}

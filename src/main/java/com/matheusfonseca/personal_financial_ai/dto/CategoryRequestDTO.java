package com.matheusfonseca.personal_financial_ai.dto;

import com.matheusfonseca.personal_financial_ai.entity.enums.TransactionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

// DTO = Estrutura do dados no corpo da requisição
// DTO para requisição de criação de categoria
public record CategoryRequestDTO(
    
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(min = 2, max = 20, message = "Nome deve ter entre 2 e 20 caracteres")
    String name,

    @NotEmpty(message = "Tipo de transação não pode ser vazio")
    TransactionType type
) {}

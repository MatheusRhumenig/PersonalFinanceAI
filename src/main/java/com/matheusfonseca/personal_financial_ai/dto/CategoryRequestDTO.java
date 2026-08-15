package com.matheusfonseca.personal_financial_ai.dto;

import com.matheusfonseca.personal_financial_ai.entity.enums.TransactionType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// DTO = Estrutura do dados no corpo da requisição
// DTO para requisição de criação de categoria
@Schema(description = "DTO para requisição de criação de categoria")
public record CategoryRequestDTO(
    
    @Schema(description = "Nome da categoria", example = "Alimentação")
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(min = 2, max = 20, message = "Nome deve ter entre 2 e 20 caracteres")
    String name,

    @Schema(description = "Tipo da transação", example = "EXPENSE ou INCOME")
    @NotNull(message = "Tipo de transação não pode ser vazio")
    TransactionType type
) {}

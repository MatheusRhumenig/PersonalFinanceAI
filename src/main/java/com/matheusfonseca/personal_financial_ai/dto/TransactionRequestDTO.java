package com.matheusfonseca.personal_financial_ai.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.matheusfonseca.personal_financial_ai.entity.enums.TransactionType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

// DTO (Data Transfer Object) para representar os dados de uma transação recebidos em uma requisição HTTP
@Schema(description = "DTO para requisição da criação de Transactions")
public record TransactionRequestDTO(

    @Schema(description = "ID do usuário proprietário da transação", example = "2")
    @NotNull(message = "Selecione um usuário")
    Long userId,

    @Schema(description = "ID da categoria associada à transação", example = "1")
    @NotNull(message = "Selecione uma categoria")
    Long categoryId,
    
    @Schema(description = "Descrição detalhada da transação", example = "Compras da semana no Supermercado")
    @NotBlank(message = "Descrição não pode ser vazia")
    String description,

    @Schema(description = "Tipo de movimentação: INCOME (Receita) ou EXPENSE (Despesa)", example = "EXPENSE")
    @NotNull(message = "Tipo de transação não pode ser vazio")
    TransactionType type,

    // Validação para garantir que o valor da transação seja maior que zero
    @Schema(description = "Valor monetário da transação (deve ser maior que zero)", example = "250.75")
    @NotNull(message = "Valor não pode ser vazio")
    @DecimalMin(value = "0.01", message = "Valor deve ser maior que zero")
    BigDecimal amount,

    // Validação para garantir que a data da transação não seja futura e esteja no formato correto
    @Schema(description = "Data em que a transação foi realizada (formato yyy-MM-dd)", example = "2026-08-14")
    @NotBlank(message = "Data não pode ser vazia")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Data não pode ser futura")
    LocalDate date
) {}

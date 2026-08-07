package com.matheusfonseca.personal_financial_ai.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.matheusfonseca.personal_financial_ai.entity.enums.TransactionType;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

// DTO (Data Transfer Object) para representar os dados de uma transação recebidos em uma requisição HTTP
public record TransactionRequestDTO(

    @NotNull(message = "Selecione um usuário")
    Long userId,

    @NotNull(message = "Selecione uma categoria")
    Long categoryId,
    
    @NotBlank(message = "Descrição não pode ser vazia")
    String description,

    @NotNull(message = "Tipo de transação não pode ser vazio")
    TransactionType type,

    // Validação para garantir que o valor da transação seja maior que zero
    @NotNull(message = "Valor não pode ser vazio")
    @DecimalMin(value = "0.01", message = "Valor deve ser maior que zero")
    BigDecimal amount,

    // Validação para garantir que a data da transação não seja futura e esteja no formato correto
    @NotBlank(message = "Data não pode ser vazia")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Data não pode ser futura")
    LocalDate date
) {}

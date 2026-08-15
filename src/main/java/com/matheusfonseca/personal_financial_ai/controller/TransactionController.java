package com.matheusfonseca.personal_financial_ai.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.matheusfonseca.personal_financial_ai.dto.TransactionRequestDTO;
import com.matheusfonseca.personal_financial_ai.dto.TransactionResponseDTO;
import com.matheusfonseca.personal_financial_ai.service.TransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Transaction Controller", description = "Endpoints para gerenciamento de transações financeiras")
@RestController
@RequiredArgsConstructor
public class TransactionController {


    private final TransactionService transactionService;

    @Operation(summary = "Cria uma nova transação", description = "Endpoint para criar uma nova transação financeira")
    @ApiResponse(responseCode = "201", description = "Transação criada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos para criação da transação")
    @PostMapping("/api/transactions")
    public ResponseEntity<String> createTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        transactionService.createTransaction(transactionRequestDTO);
        return ResponseEntity.status(201).body("Transação criada com sucesso");
    }
    
    @Operation(summary = "Obtém transações por ID do usuário", description = "Endpoint para obter as transações financeiras de um usuário específico")
    @ApiResponse(responseCode = "200", description = "Transações encontradas com sucesso")
    @ApiResponse(responseCode = "404", description = "Nenhuma transação encontrada para o usuário especificado")
    @GetMapping("/api/transactions/user/{userId}")
    public ResponseEntity<List<TransactionResponseDTO>> getTransactionsByUserId(@PathVariable Long userId) {
        List<TransactionResponseDTO> transactions = transactionService.getTransactionByUserId(userId);
        return ResponseEntity.ok(transactions);
    }
}

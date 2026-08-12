package com.matheusfonseca.personal_financial_ai.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.matheusfonseca.personal_financial_ai.dto.TransactionRequestDTO;
import com.matheusfonseca.personal_financial_ai.dto.TransactionResponseDTO;
import com.matheusfonseca.personal_financial_ai.service.TransactionService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class TransactionController {


    private final TransactionService transactionService;

    @PostMapping("/api/transactions")
    public ResponseEntity<String> createTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        transactionService.createTransaction(transactionRequestDTO);
        return ResponseEntity.status(201).body("Transação criada com sucesso");
    }
    
    @GetMapping("/api/transactions/user/{userId}")
    public ResponseEntity<List<TransactionResponseDTO>> getTransactionsByUserId(@PathVariable Long userId) {
        List<TransactionResponseDTO> transactions = transactionService.getTransactionByUserId(userId);
        return ResponseEntity.ok(transactions);
    }
}

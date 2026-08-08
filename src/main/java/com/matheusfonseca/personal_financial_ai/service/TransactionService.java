package com.matheusfonseca.personal_financial_ai.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.matheusfonseca.personal_financial_ai.dto.TransactionRequestDTO;
import com.matheusfonseca.personal_financial_ai.dto.TransactionResponseDTO;
import com.matheusfonseca.personal_financial_ai.entity.Category;
import com.matheusfonseca.personal_financial_ai.entity.Transaction;
import com.matheusfonseca.personal_financial_ai.entity.User;
import com.matheusfonseca.personal_financial_ai.exception.ResourceNotFoundException;
import com.matheusfonseca.personal_financial_ai.repository.CategoryRepository;
import com.matheusfonseca.personal_financial_ai.repository.TransactionRepository;
import com.matheusfonseca.personal_financial_ai.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public TransactionResponseDTO createTransaction(TransactionRequestDTO transactionRequestDTO) {
        
        User user = userRepository.findById(transactionRequestDTO.userId())
                .orElseThrow(() -> new ResourceNotFoundException(transactionRequestDTO.userId()));

        Category category = categoryRepository.findById(transactionRequestDTO.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException(transactionRequestDTO.categoryId()));

        // Cria um novo objeto Transaction e define seus atributos com base no DTO recebido
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionRequestDTO.amount());
        transaction.setDate(transactionRequestDTO.date());
        transaction.setDescription(transactionRequestDTO.description());
        transaction.setCategory(category);
        transaction.setUser(user);
        transaction.setType(transactionRequestDTO.type());

        // Salva a transação no repositório e retorna um DTO de resposta com os dados da transação criada
        Transaction savedTransaction = transactionRepository.save(transaction);
        return new TransactionResponseDTO(
            savedTransaction.getId(),
            savedTransaction.getDescription(),
            savedTransaction.getAmount(),
            savedTransaction.getType(),
            savedTransaction.getDate(),
            savedTransaction.getUser().getId(),
            savedTransaction.getCategory().getId()
        );
    }

    public List<TransactionResponseDTO> getTransactionByUserId(Long id) {
        // Busca a transação pelo ID no repositório, lançando uma exceção se não encontrada
        List<Transaction> transactions = transactionRepository.findByUserId(id);
        // Retorna uma lista de DTOs de resposta com os dados das transações encontradas
        return transactions.stream()
            .map(transaction -> new TransactionResponseDTO(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getDate(),
                transaction.getUser().getId(),
                transaction.getCategory().getId()
            ))
            .collect(Collectors.toList());
    }

    public List<TransactionResponseDTO> getTransactionByCategoryId(Long categoryId) {
        return transactionRepository.findAll().stream()
            .filter(transaction -> transaction.getCategory() != null
                    && categoryId.equals(transaction.getCategory().getId()))
            .map(transaction -> new TransactionResponseDTO(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getDate(),
                transaction.getUser().getId(),
                transaction.getCategory().getId()
            ))
            .collect(Collectors.toList());
    }
}

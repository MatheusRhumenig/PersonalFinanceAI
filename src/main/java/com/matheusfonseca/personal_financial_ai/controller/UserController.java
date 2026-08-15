package com.matheusfonseca.personal_financial_ai.controller;

import com.matheusfonseca.personal_financial_ai.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matheusfonseca.personal_financial_ai.dto.UserRequestDTO;
import com.matheusfonseca.personal_financial_ai.dto.UserResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "User Controller", description = "Endpoints para gerenciamento de usuários")
@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @Operation(summary = "Cria um novo usuário", description = "Endpoint para criar um novo usuário no sistema")
    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso")
    @ApiResponse(responseCode = "409", description = "Email já está em uso")
    @PostMapping("/api/users")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        userService.createUser(userRequestDTO);
        // Lógica para criar um usuário
        return ResponseEntity.status(201).body("Usuário criado com sucesso");
    }
    
    @Operation(summary = "Obtém um usuário pelo ID", description = "Endpoint para obter os detalhes de um usuário específico pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @GetMapping("/api/users/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
    
        UserResponseDTO userResponseDTO = userService.getUserById(id);

        return ResponseEntity.ok(userResponseDTO);
    }
}

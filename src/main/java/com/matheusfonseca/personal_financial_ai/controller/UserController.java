package com.matheusfonseca.personal_financial_ai.controller;

import com.matheusfonseca.personal_financial_ai.service.UserService;
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


@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        userService.createUser(userRequestDTO);
        // Lógica para criar um usuário
        return ResponseEntity.status(201).body("Usuário criado com sucesso");
    }
    
    @GetMapping("/api/users/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
    
        UserResponseDTO userResponseDTO = userService.getUserById(id);

        return ResponseEntity.ok(userResponseDTO);
    }
}

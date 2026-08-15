package com.matheusfonseca.personal_financial_ai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matheusfonseca.personal_financial_ai.dto.CategoryRequestDTO;
import com.matheusfonseca.personal_financial_ai.dto.CategoryResponseDTO;
import com.matheusfonseca.personal_financial_ai.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Category Controller", description = "Endpoints para gerenciamento de categorias de transações financeiras")
@RestController
@RequiredArgsConstructor
public class CategoryController {


    private final CategoryService categoryService;

    @Operation(summary = "Cria uma nova categoria", description = "Endpoint para criar uma nova categoria de transação financeira")
    @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso")
    @ApiResponse(responseCode = "409", description = "Categoria já existe")
    @PostMapping("/api/category")
    public ResponseEntity<String> createCategory (@Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {
        categoryService.createCategory(categoryRequestDTO);
        return ResponseEntity.status(201).body("Categoria criada com sucesso");
    }
    
    @Operation(summary = "Obtém uma categoria pelo ID", description = "Endpoint para obter os detalhes de uma categoria específica pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Categoria encontrada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @GetMapping("/api/categories/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id) {
        CategoryResponseDTO categoryResponseDTO = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryResponseDTO);
    }
}

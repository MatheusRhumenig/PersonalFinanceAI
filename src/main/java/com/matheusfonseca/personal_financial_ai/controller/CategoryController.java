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

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryController {


    private final CategoryService categoryService;

    @PostMapping("/api/category")
    public ResponseEntity<String> createCategory (@Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {
        categoryService.createCategory(categoryRequestDTO);
        return ResponseEntity.status(201).body("Categoria criada com sucesso");
    }
    
    @GetMapping("/api/categories/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id) {
        CategoryResponseDTO categoryResponseDTO = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryResponseDTO);
    }
}

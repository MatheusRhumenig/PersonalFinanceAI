package com.matheusfonseca.personal_financial_ai.service;

import java.util.stream.Collectors;
import java.util.List;
import org.springframework.stereotype.Service;

import com.matheusfonseca.personal_financial_ai.dto.CategoryRequestDTO;
import com.matheusfonseca.personal_financial_ai.dto.CategoryResponseDTO;
import com.matheusfonseca.personal_financial_ai.entity.Category;
import com.matheusfonseca.personal_financial_ai.exception.ResourceNotFoundException;
import com.matheusfonseca.personal_financial_ai.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {
        // Cria um novo objeto Category e define seus atributos com base no DTO recebido
        Category category = new Category();
        category.setName(categoryRequestDTO.name());
        category.setType(categoryRequestDTO.type());

        // Salva a categoria no repositório e retorna um DTO de resposta com os dados da categoria criada
        Category saved = categoryRepository.save(category);
        return new CategoryResponseDTO(saved.getId(), saved.getName(), saved.getType());
    }

    public CategoryResponseDTO getCategoryById(Long id) {
        // Busca a categoria pelo ID no repositório, lançando uma exceção se não encontrada
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        // Retorna um DTO de resposta com os dados da categoria encontrada
        return new CategoryResponseDTO(category.getId(), category.getName(), category.getType());
    }

    public List<CategoryResponseDTO> findAllCategories() {
        // Busca todas as categorias no repositório
        List<Category> categories = categoryRepository.findAll();
        // Converte a lista de categorias em uma lista de DTOs de resposta
        return categories.stream()
            .map(category -> new CategoryResponseDTO(category.getId(), category.getName(), category.getType()))
            .collect(Collectors.toList());
    }

}

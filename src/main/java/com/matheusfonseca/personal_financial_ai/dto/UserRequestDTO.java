package com.matheusfonseca.personal_financial_ai.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// DTO = Estrutura do dados no corpo da requisição
// DTO para requisição de criação de usuário
public record UserRequestDTO(    
    
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    String name,

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    String email,

    @NotBlank(message = "Senha é obrigatório")
    @Size(min = 6, max = 50, message = "Senha deve ter entre 6 e 50 caracteres")
    String password) {}


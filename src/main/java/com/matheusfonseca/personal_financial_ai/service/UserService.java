package com.matheusfonseca.personal_financial_ai.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.matheusfonseca.personal_financial_ai.dto.UserRequestDTO;
import com.matheusfonseca.personal_financial_ai.dto.UserResponseDTO;
import com.matheusfonseca.personal_financial_ai.entity.User;
import com.matheusfonseca.personal_financial_ai.exception.BusinessException;
import com.matheusfonseca.personal_financial_ai.exception.ResourceNotFoundException;
import com.matheusfonseca.personal_financial_ai.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

        if(userRepository.findByEmail(userRequestDTO.email())) {
            // Lança uma exceção de negócio se o email já estiver em uso
            throw new BusinessException("Email já está em uso", HttpStatus.CONFLICT);
        }else{

        // Cria um novo objeto User e define seus atributos com base no DTO recebido
        User user = new User();
        user.setName(userRequestDTO.name());
        user.setEmail(userRequestDTO.email());
        user.setPassword(userRequestDTO.password());

        User saved = userRepository.save(user);
        // Retorna um DTO de resposta com os dados do usuário criado
        return new UserResponseDTO(saved.getId(), saved.getName(), saved.getEmail());
        }
    }

    public UserResponseDTO getUserById(Long id) {
        // Busca o usuário pelo ID no repositório, lançando uma exceção se não encontrado
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        // Retorna um DTO de resposta com os dados do usuário encontrado
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }
}

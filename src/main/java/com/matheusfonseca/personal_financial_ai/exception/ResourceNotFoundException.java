package com.matheusfonseca.personal_financial_ai.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
// Exceção personalizada para indicar que um recurso não foi encontrado
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(long id) {
        super("Id não encontrado: " + id);
    }

}

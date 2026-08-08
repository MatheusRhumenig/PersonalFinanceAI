package com.matheusfonseca.personal_financial_ai.exception;

import org.springframework.http.HttpStatus;

//Logica de exception dinamica
public class BusinessException extends RuntimeException {
   
    // Define o status HTTP associado à exceção
    private final HttpStatus status;

    public BusinessException(String message, HttpStatus httpstatus) {
        this.status = httpstatus;
        super(message);
    }

    public HttpStatus getHttpstatus() {
        return status;
    }

}

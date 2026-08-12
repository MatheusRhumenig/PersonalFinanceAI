package com.matheusfonseca.personal_financial_ai.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Classe para tratamento global de exceções na aplicação
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException ex, jakarta.servlet.http.HttpServletRequest request) {
        // Cria um corpo de resposta com informações sobre a exceção
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", ex.getHttpstatus().value());
        body.put("error", ex.getHttpstatus().getReasonPhrase());
        body.put("message", ex.getMessage());
        body.put("path", request.getRequestURI()); //caminho da requisição
        
        // Retorna uma resposta HTTP com o corpo e o status da exceção
        return new ResponseEntity<>(body, ex.getHttpstatus());
    }
}

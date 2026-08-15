package com.matheusfonseca.personal_financial_ai.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    // Configuração do OpenAPI para documentação da API
    // Define as informações básicas da API, como título, versão, descrição e informações de contato
    /* a annotation Bean serve para registrar o OpenAPI como um bean no contexto do Spring, permitindo que ele seja usado para 
    gerar a documentação da API.*/
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new io.swagger.v3.oas.models.info.Info()
                .title("Personal Financial AI API")
                .version("1.0")
                .description("API para gerenciamento de transações financeiras pessoais")
                .contact(new io.swagger.v3.oas.models.info.Contact()
                        .name("Matheus Rhumenig")
                        .url("https://github.com/MatheusRhumenig/PersonalFinanceAI")));
    }
}

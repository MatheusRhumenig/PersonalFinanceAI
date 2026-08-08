package com.matheusfonseca.personal_financial_ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.matheusfonseca.personal_financial_ai.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // Método para encontrar um usuário pelo email
    boolean findByEmail(String email);
}

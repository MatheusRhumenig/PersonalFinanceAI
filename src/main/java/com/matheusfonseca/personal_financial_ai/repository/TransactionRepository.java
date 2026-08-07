package com.matheusfonseca.personal_financial_ai.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.matheusfonseca.personal_financial_ai.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Método para encontrar transações por ID do usuário
   List<Transaction> findByUserId(Long userId);

}

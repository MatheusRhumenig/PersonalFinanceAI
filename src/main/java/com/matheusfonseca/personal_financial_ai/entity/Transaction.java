package com.matheusfonseca.personal_financial_ai.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.matheusfonseca.personal_financial_ai.entity.enums.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String description;

    // Define o valor da transação com precisão e escala
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDate date;

    // Define o tipo de transação como uma enumeração
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    // Define a relação Many-to-One com a entidade User e Category
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Define a relação Many-to-One com a entidade Category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}

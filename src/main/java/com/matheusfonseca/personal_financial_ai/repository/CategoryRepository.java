package com.matheusfonseca.personal_financial_ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.matheusfonseca.personal_financial_ai.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}

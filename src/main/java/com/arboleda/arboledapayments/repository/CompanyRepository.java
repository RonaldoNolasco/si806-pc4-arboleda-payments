package com.arboleda.arboledapayments.repository;

import com.arboleda.arboledapayments.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByCategory(String category);

    List<Company> findByCategoryAndNameContaining(String category, String name);

    List<Company> findByNameContaining(String name);
}

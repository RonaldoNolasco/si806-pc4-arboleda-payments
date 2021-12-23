package com.arboleda.arboledapayments.repository;

import com.arboleda.arboledapayments.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    public List<Service> findByCompanyId(Long companyId);

    public List<Service> findByCompanyIdAndCurrency(Long companyId, String currency);
}

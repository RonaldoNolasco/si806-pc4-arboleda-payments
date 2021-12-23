package com.arboleda.arboledapayments.repository;

import com.arboleda.arboledapayments.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

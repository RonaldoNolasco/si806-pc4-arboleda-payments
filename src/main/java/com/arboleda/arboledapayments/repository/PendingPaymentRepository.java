package com.arboleda.arboledapayments.repository;

import com.arboleda.arboledapayments.model.PendingPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PendingPaymentRepository extends JpaRepository<PendingPayment, Long> {
    public List<PendingPayment> findByServiceIdAndClientServiceCodeAndPaymentId(Long serviceId, String clientServiceCode, Long paymentId);
}

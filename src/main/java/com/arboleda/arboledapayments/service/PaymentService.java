package com.arboleda.arboledapayments.service;

import com.arboleda.arboledapayments.dto.CreatePaymentDto;
import com.arboleda.arboledapayments.model.Payment;

public interface PaymentService {
    public Payment createPayment(CreatePaymentDto createPaymentDto) throws Exception;
}

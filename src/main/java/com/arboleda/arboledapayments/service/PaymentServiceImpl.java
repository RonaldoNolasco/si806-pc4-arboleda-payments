package com.arboleda.arboledapayments.service;


import com.arboleda.arboledapayments.dto.CreatePaymentDto;
import com.arboleda.arboledapayments.model.Payment;
import com.arboleda.arboledapayments.repository.AccountRepository;
import com.arboleda.arboledapayments.repository.PaymentRepository;
import com.arboleda.arboledapayments.repository.PendingPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Objects;

@org.springframework.stereotype.Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PendingPaymentRepository pendingPaymentRepository;


    public Payment createPayment(CreatePaymentDto createPaymentDto) throws Exception {
        var pendingPayment = pendingPaymentRepository
                .findById(createPaymentDto.pendingPaymentId)
                .orElseThrow();
        var account = accountRepository
                .findById(createPaymentDto.accountId)
                .orElseThrow();
        if (pendingPayment.getPayment() != null) {
            throw new Exception("Already payed");
        }
        if (!Objects.equals(account.currency, pendingPayment.service.currency)) {
            throw new Exception("Currencies must match");
        }
        if (!Objects.equals(account.user.secretKey, createPaymentDto.secretKey)) {
            throw new Exception("Secret key must match");
        }
        if (pendingPayment.pendingAmount > account.balance) {
            throw new Exception("Insuficient balance");
        }
        var payment = new Payment();
        payment.setAccount(account);
        payment.setPaymentDate(new Date());
        payment.setPendingPayment(pendingPayment);
        account.balance -= pendingPayment.pendingAmount;
        paymentRepository.save(payment);
        pendingPayment.setPayment(payment);
        pendingPaymentRepository.save(pendingPayment);
        return payment;
    }
}

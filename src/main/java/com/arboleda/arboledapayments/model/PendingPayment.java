package com.arboleda.arboledapayments.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "PENDING_PAYMENT")
public class PendingPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public PendingPayment(Long id, Service service, String clientServiceCode, double pendingAmount, Date dueDate, Payment payment) {
        this.id = id;
        this.service = service;
        this.clientServiceCode = clientServiceCode;
        this.pendingAmount = pendingAmount;
        this.dueDate = dueDate;
        this.payment = payment;
    }

    public PendingPayment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "serviceId", referencedColumnName = "id")
    public Service service;

    @Column(nullable = false)
    public String clientServiceCode;

    @Positive
    @Column
    public double pendingAmount;

    @Column
    public Date dueDate;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "paymentId", referencedColumnName = "id")
    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}

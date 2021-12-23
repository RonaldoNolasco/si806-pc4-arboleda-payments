package com.arboleda.arboledapayments.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SERVICE")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public Service(Long id, String currency, Company company, String name) {
        this.id = id;
        this.currency = currency;
        this.company = company;
        this.name = name;
    }

    public Service() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String currency;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "companyId", referencedColumnName = "id")
    public Company company;

    @Column
    public String name;

    @JsonIgnore
    @OneToMany(mappedBy = "service")
    public List<PendingPayment> pendingPayments;
}

package com.arboleda.arboledapayments.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public User(Long id, String name, String secretKey) {
        this.id = id;
        this.name = name;
        this.secretKey = secretKey;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String name;

    @Column
    @JsonIgnore
    public String secretKey;

    @OneToMany(mappedBy = "user")
    public List<Account> accounts;
}

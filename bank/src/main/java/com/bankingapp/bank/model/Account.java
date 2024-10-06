package com.bankingapp.bank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;

import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_holder_name") 
    private String accountHolderName;

    private double balance;

    public Account() {
    }

    // Constructor with parameters
    public Account(Long id, double balance, String accountHolderName) {
        this.id = id;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }
}

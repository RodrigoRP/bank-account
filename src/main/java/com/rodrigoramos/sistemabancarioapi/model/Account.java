package com.rodrigoramos.sistemabancarioapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rodrigoramos.sistemabancarioapi.model.enums.AccountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Account implements Serializable {
    private static final long serialVersionUID = 4471777119419172870L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer bankAccountNumber;
    private String agencyAccountNumber;
    private Integer accountType;
    private Double overdraft;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    private CreditCard creditCard;

    public Account(Integer bankAccountNumber, String agencyAccountNumber, AccountType accountType, Double overdraft, Customer customer, CreditCard creditCard) {
        this.bankAccountNumber = bankAccountNumber;
        this.agencyAccountNumber = agencyAccountNumber;
        this.accountType = (accountType == null) ? null : accountType.getId();
        this.overdraft = overdraft;
        this.customer = customer;
        this.creditCard = creditCard;
    }
}

package com.rodrigoramos.sistemabancarioapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rodrigoramos.sistemabancarioapi.model.enums.CustomerType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 4471777119419172870L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cpfOuCnpj;
    private Integer score;
    private Integer customerType;

    @JsonIgnore
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Account accounts;

    public Customer(Long id, String name, String cpfOuCnpj, Integer score, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.cpfOuCnpj = cpfOuCnpj;
        this.score = score;
        this.customerType = (customerType == null) ? null : customerType.getId();
    }
}

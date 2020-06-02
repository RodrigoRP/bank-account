package com.rodrigoramos.sistemabancarioapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class LimitConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer min;
    private Integer max;
    private Double overdraftLimit;
    //private Double creditCardLimit;

    public LimitConfiguration(Integer min, Integer max, Double overdraftLimit) {
        this.min = min;
        this.max = max;
        this.overdraftLimit = overdraftLimit;
        //this.creditCardLimit = creditCardLimit;
    }

}

package com.rodrigoramos.sistemabancarioapi.service.impl;

import com.rodrigoramos.sistemabancarioapi.model.Customer;
import com.rodrigoramos.sistemabancarioapi.service.CardCalculator;

public class CreditCardLimitCalculator implements CardCalculator {

    public CreditCardLimitCalculator() {
    }

    @Override
    public Double calculate(Customer customer) {

        int score = customer.getScore();

        if (score >= 0 && score <= 1) {
            return 0.00;
        } else if (score >= 2 && score <= 5) {
            return 200.00;
        } else if (score >= 6 && score <= 8) {
            return 2000.00;
        } else if (score >= 9) {
            return 15000.00;
        }
        return 0.00;
    }
}

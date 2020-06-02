package com.rodrigoramos.sistemabancarioapi.service.impl;

import com.rodrigoramos.sistemabancarioapi.service.CardCalculator;
import com.rodrigoramos.sistemabancarioapi.service.Enum.CardEnum;

public class CreditCardFactory {
    private static CreditCardFactory creditCardFactoryInstance;

    private CreditCardFactory() {
    }

    public static CreditCardFactory getInstance() {
        if (creditCardFactoryInstance == null) {
            creditCardFactoryInstance = new CreditCardFactory();
        }
        return creditCardFactoryInstance;
    }

    public CardCalculator getCardCalculator(CardEnum cardEnum) {
        switch (cardEnum) {
            case CREDIT_CARD_LIMIT_CALCULATOR: {
                return new CreditCardLimitCalculator();
            }
            default: {
                return null;
            }
        }
    }
}
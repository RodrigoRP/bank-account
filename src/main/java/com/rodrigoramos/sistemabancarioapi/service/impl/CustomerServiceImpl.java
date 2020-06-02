package com.rodrigoramos.sistemabancarioapi.service.impl;

import com.rodrigoramos.sistemabancarioapi.model.Account;
import com.rodrigoramos.sistemabancarioapi.model.CreditCard;
import com.rodrigoramos.sistemabancarioapi.model.Customer;
import com.rodrigoramos.sistemabancarioapi.model.LimitConfiguration;
import com.rodrigoramos.sistemabancarioapi.model.enums.AccountType;
import com.rodrigoramos.sistemabancarioapi.model.enums.CustomerType;
import com.rodrigoramos.sistemabancarioapi.repository.CustomerRepository;
import com.rodrigoramos.sistemabancarioapi.repository.LimitConfigurationRepository;
import com.rodrigoramos.sistemabancarioapi.service.CardCalculator;
import com.rodrigoramos.sistemabancarioapi.service.CustomerService;
import com.rodrigoramos.sistemabancarioapi.service.Enum.CardEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Value("${value.agencyAccountNumber}")
    String agencyAccountNumber;

    private final CustomerRepository customerRepository;
    private final LimitConfigurationRepository limitConfigurationRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, LimitConfigurationRepository limitConfigurationRepository) {
        this.customerRepository = customerRepository;
        this.limitConfigurationRepository = limitConfigurationRepository;
    }

    @Async
    @Override
    public Customer save(Customer customer) {
        customer.setScore(generateRandomNumber(9));
        Account account = createAccount(customer);
        customer.setAccounts(account);

        CreditCard creditCard = createCreditCard(customer);
        account.setCreditCard(creditCard);

        return customerRepository.save(customer);
    }

    private CreditCard createCreditCard(Customer customer) {
        CardCalculator cardCalculator = CreditCardFactory
                .getInstance()
                .getCardCalculator(CardEnum.CREDIT_CARD_LIMIT_CALCULATOR);

        double limitCreditCard = cardCalculator.calculate(customer);
        return new CreditCard(null, limitCreditCard, customer.getAccounts());
    }

    @Override
    public Account createAccount(Customer customer) {
        int accountNumber = generateRandomNumber(999999);
        double overdraftLimit = getLimitAccount(customer).getOverdraftLimit();
        AccountType accountType = getAccountType(customer);

        return new Account(accountNumber, agencyAccountNumber, accountType, overdraftLimit, customer, null);
    }

    private LimitConfiguration getLimitAccount(Customer customer) {
        return limitConfigurationRepository.findLimit(customer.getScore());
    }

    @Async
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    private AccountType getAccountType(Customer customer) {
        AccountType accountType = AccountType.INDEFINIDA;

        if (customer.getCustomerType().equals(CustomerType.PESSOAFISICA.getId())) {
            accountType = AccountType.CORRENTE;
        } else if (customer.getCustomerType().equals(CustomerType.PESSOAJURIDICA.getId())) {
            accountType = AccountType.EMPRESARIAL;
        }
        return accountType;
    }


    private int generateRandomNumber(int max) {
        return (int) (Math.random() * max);
    }


}

package com.rodrigoramos.sistemabancarioapi.service;

import com.rodrigoramos.sistemabancarioapi.model.Account;
import com.rodrigoramos.sistemabancarioapi.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    Account createAccount(Customer customer);

    List<Customer> findAll();

}

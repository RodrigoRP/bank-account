package com.rodrigoramos.sistemabancarioapi.repository;

import com.rodrigoramos.sistemabancarioapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

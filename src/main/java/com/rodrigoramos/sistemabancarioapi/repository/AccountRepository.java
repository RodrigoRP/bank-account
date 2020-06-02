package com.rodrigoramos.sistemabancarioapi.repository;

import com.rodrigoramos.sistemabancarioapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

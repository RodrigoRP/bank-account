package com.rodrigoramos.sistemabancarioapi.service.impl;

import com.rodrigoramos.sistemabancarioapi.model.Account;
import com.rodrigoramos.sistemabancarioapi.repository.AccountRepository;
import com.rodrigoramos.sistemabancarioapi.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository repo;

    @Async
    @Override
    public List<Account> findAll() {
        return repo.findAll();
    }
}

package com.rodrigoramos.sistemabancarioapi.service;

import com.rodrigoramos.sistemabancarioapi.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();
}

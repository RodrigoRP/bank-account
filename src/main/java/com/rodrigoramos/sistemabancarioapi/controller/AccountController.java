package com.rodrigoramos.sistemabancarioapi.controller;

import com.rodrigoramos.sistemabancarioapi.controller.constant.RestConstant;
import com.rodrigoramos.sistemabancarioapi.model.Account;
import com.rodrigoramos.sistemabancarioapi.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(RestConstant.APPLICATION_NAME + RestConstant.API_VERSION_1 + RestConstant.RESOURCE_ACCOUNT)
public class AccountController {

    private AccountService accountService;

    @GetMapping("/")
    public ResponseEntity<List<Account>> findAllAccounts() {
        List<Account> accounts = accountService.findAll();

        return ResponseEntity.ok().body(accounts);
    }

}

package com.rodrigoramos.sistemabancarioapi.controller;

import com.rodrigoramos.sistemabancarioapi.model.Account;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;
@Api(tags = "Account API")
public interface AccountController {

    @ApiOperation("Find All Accounts")
    ResponseEntity<List<Account>> findAllAccounts();
}

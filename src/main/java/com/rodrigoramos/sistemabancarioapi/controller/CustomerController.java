package com.rodrigoramos.sistemabancarioapi.controller;


import com.rodrigoramos.sistemabancarioapi.dto.CustomerNewDTO;
import com.rodrigoramos.sistemabancarioapi.model.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Customer API")
public interface CustomerController {

    @ApiOperation("Create new Customer")
    ResponseEntity<Void> createCustomer(@Valid @RequestBody CustomerNewDTO customerNewDTO);

    @ApiOperation("Find All Customers")
    ResponseEntity<List<Customer>> findAllCustomer();

}

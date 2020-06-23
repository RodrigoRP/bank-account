package com.rodrigoramos.sistemabancarioapi.controller.impl;

import com.rodrigoramos.sistemabancarioapi.controller.CustomerController;
import com.rodrigoramos.sistemabancarioapi.controller.constant.RestConstant;
import com.rodrigoramos.sistemabancarioapi.converter.CustomerConverter;
import com.rodrigoramos.sistemabancarioapi.dto.CustomerNewDTO;
import com.rodrigoramos.sistemabancarioapi.model.Customer;
import com.rodrigoramos.sistemabancarioapi.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(RestConstant.APPLICATION_NAME + RestConstant.API_VERSION_1 + RestConstant.RESOURCE_CUSTOMER)
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;
    private final CustomerConverter converter;

    @Override
    @PostMapping("/")
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody CustomerNewDTO customerNewDTO) {
        Customer customer = converter.convertToModel(customerNewDTO);
        customer = customerService.save(customer);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(customer.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Customer>> findAllCustomer() {
        List<Customer> customers = customerService.findAll();

        return ResponseEntity.ok().body(customers);
    }

}

package com.rodrigoramos.sistemabancarioapi.converter;

import com.rodrigoramos.sistemabancarioapi.dto.CustomerNewDTO;
import com.rodrigoramos.sistemabancarioapi.model.Customer;
import com.rodrigoramos.sistemabancarioapi.model.enums.CustomerType;
import org.springframework.stereotype.Service;

@Service
public class CustomerConverter {

    public Customer convertToModel(CustomerNewDTO customerNewDTO) {
        Customer customer = Customer.builder()
                .name(customerNewDTO.getName())
                .cpfOuCnpj(customerNewDTO.getCpfOuCnpj())
                .customerType(CustomerType.toEnum(customerNewDTO.getCustomerType()).getId())
                .build();

        return customer;
    }


}

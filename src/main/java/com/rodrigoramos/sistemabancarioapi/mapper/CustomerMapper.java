package com.rodrigoramos.sistemabancarioapi.mapper;

import com.rodrigoramos.sistemabancarioapi.dto.CustomerNewDTO;
import com.rodrigoramos.sistemabancarioapi.model.Customer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomerMapper {

    private final ModelMapper modelMapper;

    public Customer convertToModel(CustomerNewDTO dto) {
        return modelMapper.map(dto, Customer.class);
    }
}

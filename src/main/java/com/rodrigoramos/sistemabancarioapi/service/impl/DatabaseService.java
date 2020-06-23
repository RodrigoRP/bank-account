package com.rodrigoramos.sistemabancarioapi.service.impl;

import com.rodrigoramos.sistemabancarioapi.dto.CustomerNewDTO;
import com.rodrigoramos.sistemabancarioapi.mapper.CustomerMapper;
import com.rodrigoramos.sistemabancarioapi.model.Customer;
import com.rodrigoramos.sistemabancarioapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DatabaseService {

    private final CustomerService service;
    private final CustomerMapper converter;

    public void instantiateDatabase() {
        CustomerNewDTO c1 = new CustomerNewDTO("Adamasor", "123123", 1);
        Customer cc1 = converter.convertToModel(c1);
        CustomerNewDTO c2 = new CustomerNewDTO("Pedro", "123123", 1);
        Customer cc2 = converter.convertToModel(c2);

        CustomerNewDTO c3 = new CustomerNewDTO("Jose", "123123", 1);
        Customer cc3 = converter.convertToModel(c3);

        CustomerNewDTO c4 = new CustomerNewDTO("Marau", "123123", 1);
        Customer cc4 = converter.convertToModel(c4);

        CustomerNewDTO c5 = new CustomerNewDTO("Ricardo", "123123", 1);
        Customer cc5 = converter.convertToModel(c5);

        CustomerNewDTO c6 = new CustomerNewDTO("Ronaldo", "123123", 2);
        Customer cc6 = converter.convertToModel(c6);

        CustomerNewDTO c7 = new CustomerNewDTO("Paulo", "123123", 2);
        Customer cc7 = converter.convertToModel(c7);

        CustomerNewDTO c8 = new CustomerNewDTO("Joao", "123123", 2);
        Customer cc8 = converter.convertToModel(c8);

        CustomerNewDTO c9 = new CustomerNewDTO("Adamastor", "123123", 2);
        Customer cc9 = converter.convertToModel(c9);


        service.save(cc1);
        service.save(cc2);
        service.save(cc3);
        service.save(cc4);
        service.save(cc5);
        service.save(cc6);
        service.save(cc7);
        service.save(cc8);
        service.save(cc9);
        // customerRepository.saveAll(Arrays.asList(cc1, cc2, cc3, cc4, cc5, cc6, cc7, cc8, cc9));


    }
}

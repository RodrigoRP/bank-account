package com.rodrigoramos.sistemabancarioapi.service;

import com.rodrigoramos.sistemabancarioapi.model.Customer;
import com.rodrigoramos.sistemabancarioapi.model.enums.CustomerType;
import com.rodrigoramos.sistemabancarioapi.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.when;



@SpringBootTest
public class CustomerServiceTest {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Test
    public void whenCreate_thenPersistData() {
        // given
        Customer customer = new Customer(1L, "Pedro", "95720821082", null, CustomerType.PESSOAFISICA);
        given(customerRepository.save(any(Customer.class))).willReturn(customer(1L));

        // when
        Customer customerSave = customerService.save(customer);

        // then
        assertThat(customerSave.getName()).isEqualTo("Pedro");
    }

    @Test
    public void findAllCustomers() {
        // given
        final List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer(1L, "PedroJose", "95720821082", null, CustomerType.PESSOAFISICA);
        customers.add(customer1);

        // when
        when(customerRepository.findAll()).thenReturn(customers);

        // then
        List<Customer> actual = customerService.findAll();
        assertThat(actual.size()).isEqualTo(1);
    }



    private Customer customer(Long id) {
        return new Customer(id, "Pedro", "95720821082", null, CustomerType.PESSOAFISICA);
    }

}



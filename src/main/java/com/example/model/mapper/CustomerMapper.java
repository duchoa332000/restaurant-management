package com.example.model.mapper;

import com.example.model.dto.CustomerDTO;
import com.example.model.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public CustomerDTO entityToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        return customerDTO;
    }

    public List<CustomerDTO> entityToDTO(List<Customer> customers) {
        return customers.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    ///
    public Customer dtoToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        return customer;
    }

    public List<Customer> dtoToEntity(List<CustomerDTO> customerDTOS) {
        return customerDTOS.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}

package com.example.service;

import com.example.exception.ApplicationExceptionsNotFound;
import com.example.model.dto.CustomerDTO;
import com.example.model.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer) throws ApplicationExceptionsNotFound;

    /**
     * Find all Customer
     *
     * @return
     */
    List<CustomerDTO> findAll();
}

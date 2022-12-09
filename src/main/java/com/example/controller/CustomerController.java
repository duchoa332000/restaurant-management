package com.example.controller;

import com.example.model.dto.CustomerDTO;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customermanage.com")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Find all Customer version 1
     *
     * @return
     */
    @GetMapping("v1/customers")
    public List<CustomerDTO> findAll() {
        return customerService.findAll();
    }
}

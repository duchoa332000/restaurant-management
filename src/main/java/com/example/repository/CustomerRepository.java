package com.example.repository;

import com.example.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    public Customer getCustomerByEmailAndName(String email, String name);
}

package com.example.NoBSSpringBoot.services;

import com.example.NoBSSpringBoot.Entity.Customer;
import com.example.NoBSSpringBoot.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    public ResponseEntity<Customer> getCustomer(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }
        return ResponseEntity.ok(customer.get());
    }
}

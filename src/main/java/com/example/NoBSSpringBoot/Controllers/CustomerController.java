package com.example.NoBSSpringBoot.Controllers;


import com.example.NoBSSpringBoot.Entity.Customer;
import com.example.NoBSSpringBoot.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    ResponseEntity<List<Customer>> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
        return customerService.getCustomer(id);
    }

}

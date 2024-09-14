package com.example.NoBSSpringBoot.Repositories;

import com.example.NoBSSpringBoot.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
package com.practice.pizzeria.services;

import com.practice.pizzeria.persistance.entity.CustomerEntity;
import com.practice.pizzeria.persistance.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<CustomerEntity> getAllCustomer() {
        return this.customerRepository.findAll();
    }

    public CustomerEntity findByPhoneNumber(String phone) {
        return this.customerRepository.findByNumber(phone);
    }
}

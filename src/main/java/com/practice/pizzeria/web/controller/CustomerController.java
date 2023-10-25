package com.practice.pizzeria.web.controller;

import com.practice.pizzeria.persistance.entity.CustomerEntity;
import com.practice.pizzeria.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CustomerEntity>> getAllCustomer() {
        return ResponseEntity.ok(this.customerService.getAllCustomer());
    }

    @GetMapping("/phone")
    public ResponseEntity<CustomerEntity> getByPhoneNumber(@RequestParam(defaultValue = "0") String phone) {
        return ResponseEntity.ok(this.customerService.findByPhoneNumber(phone));
    }
}

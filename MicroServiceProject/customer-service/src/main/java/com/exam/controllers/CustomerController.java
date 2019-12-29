package com.exam.controllers;

import com.exam.dao.CustomerRepository;
import com.exam.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable("id")  long id){
        return customerRepository.getOne(id);
    }


}

package com.exam.billingservice.service;

import com.exam.billingservice.entities.Customer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "CUSTOMER-SERVICE")
@RibbonClient(name = "CUSTOMER-SERVICE")
public interface CustomerServiceClient {
    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable("id") long id);
}

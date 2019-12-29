package com.exam.billingservice;

import com.exam.billingservice.dao.BillRepository;
import com.exam.billingservice.dao.ProductItemRepository;
import com.exam.billingservice.entities.Bill;
import com.exam.billingservice.entities.Customer;
import com.exam.billingservice.entities.ProductItem;
import com.exam.billingservice.service.CustomerServiceClient;
import com.exam.billingservice.service.InventoryServiceClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository,
                            InventoryServiceClient inventoryServiceClient, CustomerServiceClient customerServiceClient){
        return args -> {
            Bill bill=new Bill();
            bill.setBillingDate(new Date());
            Customer customer=customerServiceClient.findCustomerById(1);
            System.out.println(customer);
            bill.setCustomerId(customer.getId());
            bill.setCustomer(customer);
            billRepository.save(bill);
            inventoryServiceClient.findAll().forEach(p->{
                System.out.println(p);
                productItemRepository.save(new ProductItem(null,null,p.getId(),p.getPrice(),(int)(1+Math.random()*1000),bill));
            });
        };

    }}

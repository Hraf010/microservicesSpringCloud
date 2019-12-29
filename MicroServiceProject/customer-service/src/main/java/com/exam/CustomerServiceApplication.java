package com.exam;

import com.exam.dao.CustomerRepository;
import com.exam.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(new Customer(null,"Enset","contact@enset.ma"));
            customerRepository.save(new Customer(null,"Ehtp","contact@ehtp.ma"));
            customerRepository.save(new Customer(null,"Fst","contact@fst.ma"));
            customerRepository.findAll().forEach(System.out::println);
        };
    }

}

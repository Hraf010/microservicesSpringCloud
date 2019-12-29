package com.exam;

import com.exam.dao.ProduitRepository;
import com.exam.entities.Produit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProduitRepository produitRepository){
        return args -> {
            produitRepository.save(new Produit(null,"P1",2000));
            produitRepository.save(new Produit(null,"P2",3000));
            produitRepository.save(new Produit(null,"P3",4000));
            produitRepository.findAll().forEach(System.out::println);
        };
    }



}

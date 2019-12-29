package com.exam.billingservice.service;

import com.exam.billingservice.entities.Produit;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "INVENTORY-SERVICE")
@RibbonClient(name = "INVENTORY-SERVICE")
public interface InventoryServiceClient {
    @GetMapping("/produits/{id}")
    Produit findProduitById(@PathVariable("id") Long id);
    @GetMapping("/produits")
    List<Produit> findAll();
}

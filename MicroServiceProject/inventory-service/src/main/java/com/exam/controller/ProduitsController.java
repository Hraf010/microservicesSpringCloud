package com.exam.controller;

import com.exam.dao.ProduitRepository;
import com.exam.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProduitsController {
    @Autowired
    private ProduitRepository produitRepository;
    @GetMapping("/produits")
    List<Produit> getAllProduits(){
        return produitRepository.findAll();
    }
    @GetMapping("/produits/{id}")
    Produit getProduitById(@PathVariable long id){
        return produitRepository.getOne(id);
    }
}

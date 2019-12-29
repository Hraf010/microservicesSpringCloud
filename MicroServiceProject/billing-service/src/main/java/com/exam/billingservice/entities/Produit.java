package com.exam.billingservice.entities;

import lombok.Data;

@Data
public class Produit {
    private Long id;
    private String designation;
    private double price;
}

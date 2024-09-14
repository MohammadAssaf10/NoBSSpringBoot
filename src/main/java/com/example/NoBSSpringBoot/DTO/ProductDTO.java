package com.example.NoBSSpringBoot.DTO;

import com.example.NoBSSpringBoot.Entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class ProductDTO {
    private String name;
    private String description;
    private Double price;

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }

    public ProductDTO(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}

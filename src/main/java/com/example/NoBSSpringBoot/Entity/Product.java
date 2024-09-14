package com.example.NoBSSpringBoot.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Product")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "price",nullable = false)
    private Double price;
    @Column(name = "quantity",nullable = false)
    private Integer quantity;
}

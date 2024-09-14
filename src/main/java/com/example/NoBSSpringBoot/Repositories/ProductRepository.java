package com.example.NoBSSpringBoot.Repositories;

import com.example.NoBSSpringBoot.DTO.ProductDTO;
import com.example.NoBSSpringBoot.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT p FROM Product p WHERE p.price < :maxPrice")
    List<Product> findProductsWithPriceLessThan(@Param("maxPrice") double maxPrice);

    @Query("SELECT new com.example.NoBSSpringBoot.DTO.ProductDTO(p.name, p.description, p.price) FROM Product p")
    List<ProductDTO> findAllProductsDTOs();

    @Query("SELECT p FROM Product p WHERE p.description LIKE %:description%")
//    @Query(value = "SELECT * FROM products p WHERE p.description LIKE %:description%",nativeQuery = true)
    List<Product> findProductsByDescription(String description);
}
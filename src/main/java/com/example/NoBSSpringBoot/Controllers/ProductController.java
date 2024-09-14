package com.example.NoBSSpringBoot.Controllers;


import com.example.NoBSSpringBoot.DTO.ProductDTO;
import com.example.NoBSSpringBoot.Entity.Product;
import com.example.NoBSSpringBoot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return productService.getProductsDTOS();
    }

    @GetMapping("/search/{maxPrice}")
    public ResponseEntity<List<Product>> getProductsWithPriceLessThan(@PathVariable Double maxPrice) {
        return productService.getProductsWithPriceLessThan(maxPrice);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductsByDescription(@RequestParam(value = "description") String description) {
        return productService.searchProductsByDescription(description);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }


    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }
}

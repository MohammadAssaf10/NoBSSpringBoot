package com.example.NoBSSpringBoot.services;

import com.example.NoBSSpringBoot.DTO.ProductDTO;
import com.example.NoBSSpringBoot.Entity.Product;
import com.example.NoBSSpringBoot.Repositories.ProductRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<List<Product>> getProducts() {
        List<Product> product = productRepository.findAll();
        return ResponseEntity.ok(product);
    }

    public ResponseEntity<List<ProductDTO>> getProductsDTOS() {
        List<ProductDTO> productDTOS = productRepository.findAllProductsDTOs();
        return ResponseEntity.ok(productDTOS);
    }

    public ResponseEntity<ProductDTO> getProduct(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        return ResponseEntity.ok(new ProductDTO(product.get()));
    }

    public ResponseEntity<List<Product>> getProductsWithPriceLessThan(double maxPrice) {
        return ResponseEntity.ok(productRepository.findProductsWithPriceLessThan(maxPrice));
    }

    public ResponseEntity<Void> createProduct(Product product) {
        validateProduct(product);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<Product>> searchProductsByDescription(String description) {
        return ResponseEntity.ok(productRepository.findProductsByDescription(description));
    }

    public ResponseEntity<Void> updateProduct(Integer id, Product product) {
        validateProduct(product);
        product.setId(id);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> deleteProduct(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        productRepository.delete(product.get());
        return ResponseEntity.ok().build();
    }

    private void validateProduct(Product product) {
        if (StringUtils.isBlank(product.getName())) {
            throw new RuntimeException("Product name cannot be empty");
        }
        if (StringUtils.isBlank(product.getDescription())) {
            throw new RuntimeException("Product description cannot be empty");
        }
        if (product.getPrice() <= 0.0) {
            throw new RuntimeException("Product price cannot be zero or negative");
        }
        if (product.getQuantity() <= 0.0) {
            throw new RuntimeException("Product quantity cannot be zero or negative");
        }
    }
}

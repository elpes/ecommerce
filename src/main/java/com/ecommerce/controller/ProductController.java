package com.ecommerce.controller;

import com.ecommerce.URI;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(URI.PRODUCTS)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping(URI.PRODUCT_ID)
    public Product getProductById(@PathVariable(value = "id") Long productId) {

        return productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException());
    }

    @PostMapping(URI.PRODUCTS)
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping(URI.PRODUCT_ID)
    public Product updateProduct(@PathVariable(value = "id") Long productId, @RequestBody Product productDetails) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException());
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    @DeleteMapping(URI.PRODUCT_ID)
    public ResponseEntity<?> deleteProduct(		@PathVariable(value = "id") Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException());
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
}


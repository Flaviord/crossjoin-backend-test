package com.backend.controller;

import com.backend.entities.Product;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.rest.request.ProductRequest;
import com.backend.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> allProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        Product productById = productService.getProductById(id);
        if (productById == null) {
            throw new ResourceNotFoundException("Product not found");
        }
        return productById;
    }

    @PostMapping("/{id}")
    public Product save(@PathVariable Long id, @RequestBody ProductRequest request) {
        Product productById = productService.getProductById(id);
        if (productById == null) {
            throw new ResourceNotFoundException("Product not found");
        }
        return productService.save(request);
    }
}

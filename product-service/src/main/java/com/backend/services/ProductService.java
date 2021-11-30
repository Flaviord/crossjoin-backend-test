package com.backend.services;

import com.backend.entities.Product;
import com.backend.repository.ProductRepository;
import com.backend.rest.request.ProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    @Autowired private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.getById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Product save(ProductRequest request) {
        var newProduct = new Product(request.getName(), request.getQuantity());
        var saved = repository.save(newProduct);
        log.debug("PRODUCT SAVED {}", saved);
        return saved;
    }
}

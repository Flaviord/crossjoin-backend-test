package com.backend.controller;

import com.backend.entities.Product;
import com.backend.entities.Store;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.rest.request.StoreRequest;
import com.backend.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("store")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> getAllStore() {
        return storeService.getAllStore();
    }

    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable Long id) {
        Store storeById = storeService.getStoreById(id);
        if (storeById == null) {
            throw new ResourceNotFoundException("Store not saved. Store not exists.");
        }
        return storeById;
    }

    @GetMapping("/{id}/products")
    public List<Product> getProductsByStoreId(@PathVariable Long id) {
        return storeService.getProductsByStoreId(id);
    }

    @PostMapping("/{id}")
    public Store saveStore(@PathVariable Long id, @RequestBody StoreRequest request) {
        Store storeById = storeService.getStoreById(id);
        if (storeById == null) {
            throw new ResourceNotFoundException("Store not saved. Store not exists.");
        }
        return storeService.saveStore(request);
    }
}

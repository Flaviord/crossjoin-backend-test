package com.backend.controller;

import com.backend.entities.Product;
import com.backend.entities.Store;
import com.backend.rest.request.StoreRequest;
import com.backend.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> getAllStore() {
        return storeService.getAllStore();
    }

    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable Long id) {
        return storeService.getStoreById(id);
    }

    @GetMapping("/{id}/products")
    public List<Product> getProductsByStoreId(@PathVariable Long id) {
        return storeService.getProductsByStoreId(id);
    }

    @PostMapping
    public Store saveStore(@RequestBody StoreRequest request) {
        return storeService.saveStore(request);
    }
}

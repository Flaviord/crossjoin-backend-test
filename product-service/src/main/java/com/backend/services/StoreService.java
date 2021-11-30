package com.backend.services;

import com.backend.entities.Product;
import com.backend.entities.Store;
import com.backend.repository.StoreRepository;
import com.backend.rest.request.StoreRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getAllStore() {
        return storeRepository.findAll();
    }

    public Store getStoreById(Long id) {
        return storeRepository.getById(id);
    }

    public Store saveStore(StoreRequest request) {
        var store = new Store();
        store.setName(request.getName());
        return storeRepository.save(store);
    }

    public List<Product> getProductsByStoreId(Long storeId) {
        return storeRepository.findAllByStoreId(storeId);
    }
}

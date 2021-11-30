package com.backend.repository;

import com.backend.entities.Product;
import com.backend.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query(value = "SELECT p FROM Product p WHERE p.store.id = ?1")
    List<Product> findAllByStoreId(Long storeId);
}

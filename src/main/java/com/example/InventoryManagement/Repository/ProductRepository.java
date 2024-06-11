package com.example.InventoryManagement.Repository;

import com.example.InventoryManagement.Entity.Category;
import com.example.InventoryManagement.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
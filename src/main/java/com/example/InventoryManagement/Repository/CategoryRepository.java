package com.example.InventoryManagement.Repository;

import com.example.InventoryManagement.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
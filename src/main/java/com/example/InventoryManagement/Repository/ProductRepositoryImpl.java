package com.example.InventoryManagement.Repository;

import com.example.InventoryManagement.Entity.Category;
import com.example.InventoryManagement.Entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public abstract class ProductRepositoryImpl implements ProductRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findByCategory(Category category) {
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.category = :category", Product.class);
        query.setParameter("category", category);
        return query.getResultList();
    }

}

package com.example.InventoryManagement.Mappers;

import com.example.InventoryManagement.Entity.Category;
import com.example.InventoryManagement.Entity.Product;
import com.example.InventoryManagement.dto.CategoryDTO;
import com.example.InventoryManagement.dto.ProductDTO;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {
    public ProductDTO toDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantityInStock(product.getQuantityInStock());
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(product.getCategory().getId());
        dto.setCategory(categoryDTO);
        return dto;
    }

    public Product toEntity(ProductDTO dto, Category category) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantityInStock(dto.getQuantityInStock());
        product.setCategory(category);
        return product;
    }
}
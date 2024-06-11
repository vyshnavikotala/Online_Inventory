package com.example.InventoryManagement.Mappers;

import com.example.InventoryManagement.Entity.Category;
import com.example.InventoryManagement.dto.CategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDTO toDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    public Category toEntity(CategoryDTO dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }
}
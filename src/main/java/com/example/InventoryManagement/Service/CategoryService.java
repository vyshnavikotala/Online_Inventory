package com.example.InventoryManagement.Service;

import com.example.InventoryManagement.Entity.Category;
import com.example.InventoryManagement.Mappers.CategoryMapper;
import com.example.InventoryManagement.Repository.CategoryRepository;
import com.example.InventoryManagement.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        return categoryMapper.toDTO(categoryRepository.save(category));
    }

    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        return categoryMapper.toDTO(categoryRepository.save(category));
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDTO).collect(Collectors.toList());
    }
}
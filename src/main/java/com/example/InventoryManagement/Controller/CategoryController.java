package com.example.InventoryManagement.Controller;

import com.example.InventoryManagement.Entity.Category;
import com.example.InventoryManagement.Service.CategoryService;
import com.example.InventoryManagement.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.addCategory(categoryDTO);
    }

    @PutMapping
    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.updateCategory(categoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
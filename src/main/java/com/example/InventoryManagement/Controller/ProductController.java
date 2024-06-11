package com.example.InventoryManagement.Controller;

import com.example.InventoryManagement.Entity.Category;
import com.example.InventoryManagement.Entity.Product;
import com.example.InventoryManagement.Service.ProductService;
import com.example.InventoryManagement.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @PutMapping
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

  /*  @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductsByCategory(@PathVariable Category category) {
        return productService.getProductsByCategory(category);
    }*/
    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductsByCategory(@PathVariable Long categoryId) {
        Category category = new Category();
        category.setId(categoryId);
        return productService.getProductsByCategory(category);
    }
}
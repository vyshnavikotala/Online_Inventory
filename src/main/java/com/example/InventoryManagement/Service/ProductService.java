package com.example.InventoryManagement.Service;

import com.example.InventoryManagement.Entity.Category;
import com.example.InventoryManagement.Entity.Product;
import com.example.InventoryManagement.Mappers.ProductMapper;
import com.example.InventoryManagement.Repository.CategoryRepository;
import com.example.InventoryManagement.Repository.ProductRepository;
import com.example.InventoryManagement.dto.CategoryDTO;
import com.example.InventoryManagement.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductDTO addProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategory()).orElseThrow();
        Product product = productMapper.toEntity(productDTO, category);
        return productMapper.toDTO(productRepository.save(product));
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategory()).orElseThrow();
        Product product = productMapper.toEntity(productDTO, category);
        return productMapper.toDTO(productRepository.save(product));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::toDTO).collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category).stream().map(productMapper::toDTO).collect(Collectors.toList());
    }
}
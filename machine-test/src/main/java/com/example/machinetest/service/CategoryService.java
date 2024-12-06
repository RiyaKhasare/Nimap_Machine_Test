package com.example.machinetest.service;

import com.example.machinetest.entity.Category;
import com.example.machinetest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service

public class CategoryService {
	  @Autowired
	    private CategoryRepository categoryRepository;

	    public Page<Category> getAllCategories(int page, int size) {
	        return categoryRepository.findAll(PageRequest.of(page, size));
	    }

	    public Category getCategoryById(Long id) {
	        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
	    }

	    public Category createCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    public Category updateCategory(Long id, Category categoryDetails) {
	        Category category = getCategoryById(id);
	        category.setName(categoryDetails.getName());
	        return categoryRepository.save(category);
	    }

	    public void deleteCategoryById(Long id) {
	        if (categoryRepository.existsById(id)) {
	            categoryRepository.deleteById(id);
	        } else {
	            throw new RuntimeException("Category not found with id: " + id);
	        }
	    }

}

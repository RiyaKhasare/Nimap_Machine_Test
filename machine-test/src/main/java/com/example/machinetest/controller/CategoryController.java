package com.example.machinetest.controller;

import com.example.machinetest.entity.Category;
import com.example.machinetest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	  @Autowired
	    private CategoryService categoryService;

	    @GetMapping
	    public Page<Category> getAllCategories(@RequestParam int page, @RequestParam int size) {
	        return categoryService.getAllCategories(page, size);
	    }

	    @GetMapping("/{id}")
	    public Category getCategoryById(@PathVariable Long id) {
	        return categoryService.getCategoryById(id);
	    }

	    @PostMapping
	    public Category createCategory(@RequestBody Category category) {
	        return categoryService.createCategory(category);
	    }

	    @PutMapping("/{id}")
	    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
	        return categoryService.updateCategory(id, category);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
	        try {
	            categoryService.deleteCategoryById(id);
	            return ResponseEntity.ok("Category deleted successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                                 .body("Error deleting category: " + e.getMessage());
	        }
	    }
}

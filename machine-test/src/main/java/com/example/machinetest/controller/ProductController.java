package com.example.machinetest.controller;

import com.example.machinetest.entity.Product;
import com.example.machinetest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
    private ProductService productService;

	@GetMapping("/products")
	public Page<Product> getAllProducts(@RequestParam int page, @RequestParam int size) {
	    return productService.getAllProducts(page, size);
	}

	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable Long id) {
	    return productService.getProductById(id);
	}

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        if (product.getPrice() == null) {
            product.setPrice(0.0);
        }

        Product savedProduct = productService.createProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}") 
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/products/{id}") 
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build(); 
    }
}

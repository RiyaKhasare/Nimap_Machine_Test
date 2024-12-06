package com.example.machinetest.service;

import com.example.machinetest.entity.Product;
import com.example.machinetest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ProductService {
	@Autowired
    private ProductRepository productRepository;

    public Page<Product> getAllProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product createProduct(Product product) {
        if (product.getPrice() == null) {
            product.setPrice(0.0); 
        }

        
        return productRepository.save(product);
    }


    public Product updateProduct(Long id, Product product) {
        return productRepository.findById(id)
            .map(existingProduct -> {
                // Update only non-null fields
                if (product.getName() != null) existingProduct.setName(product.getName());
                if (product.getPrice() != null) existingProduct.setPrice(product.getPrice());
                if (product.getDescription() != null) existingProduct.setDescription(product.getDescription());
                return productRepository.save(existingProduct);
            })
            .orElseThrow(() -> new RuntimeException("Product not found with id: " + id)); // Simplified exception
    }
    
    public void deleteProductById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product not found with id: " + id); // Simplified exception
        }
    }


    	 

}

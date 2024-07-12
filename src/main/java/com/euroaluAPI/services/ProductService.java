package com.euroaluAPI.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.euroaluAPI.models.Product;
import com.euroaluAPI.repositories.ProductRepository;

@Service
public class ProductService {
	 @Autowired
	    private ProductRepository productRepository;

	    public List<Product> getAllCategories() {
	        return productRepository.findAll();
	    }

	    public Product getProductById(Long id) {
	        return productRepository.findById(id)
	                .orElseThrow(() -> new NoSuchElementException("Product not found: " + id));
	    }
//	    public Product getEvnetByIdStr(String id) {
//	    	return getProductById(Long.parseInt(id));
//	    }

	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }

	    public Product updateProduct(Product product) {
	        return productRepository.save(product);
	    }

	    public void deleteProduct(Long id) {
	        productRepository.deleteById(id);
	    }
}

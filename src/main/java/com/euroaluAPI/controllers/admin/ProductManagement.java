package com.euroaluAPI.controllers.admin;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.euroaluAPI.models.Product;
import com.euroaluAPI.services.ProductService;


@RestController
@RequestMapping("api/admin/products")
public class ProductManagement{

    @Autowired
    private ProductService productService;
 

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllCategories();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
        try {
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (NoSuchElementException e) {
//            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 404);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        } catch (Exception e) {
//            ErrorResponse errorResponse = new ErrorResponse("An error occurred", 500);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws Exception {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        try {
        	Product existingProduct = productService.getProductById(id);        	
        	product.setId(id);
            Product updatedProduct = productService.updateProduct(product);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
        	
        	e.printStackTrace();	
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        	
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        Product existingProduct = productService.getProductById(id);
        if (existingProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
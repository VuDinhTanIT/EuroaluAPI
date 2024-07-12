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

import com.euroaluAPI.models.SubCategory;
import com.euroaluAPI.services.SubCategoryService;


@RestController
@RequestMapping("api/admin/sub-categories")
public class SubCategoryManagement{

    @Autowired
    private SubCategoryService subCategoryService;
 

    @GetMapping
    public ResponseEntity<List<SubCategory>> getAllCategories() {
        List<SubCategory> subCategorys = subCategoryService.getAllCategories();
        return new ResponseEntity<>(subCategorys, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getSubCategoryById(@PathVariable("id") Long id) {
        try {
            SubCategory subCategory = subCategoryService.getSubCategoryById(id);
            return ResponseEntity.ok(subCategory);
        } catch (NoSuchElementException e) {
//            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 404);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        } catch (Exception e) {
//            ErrorResponse errorResponse = new ErrorResponse("An error occurred", 500);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<SubCategory> createSubCategory(@RequestBody SubCategory subCategory) throws Exception {
        SubCategory createdSubCategory = subCategoryService.createSubCategory(subCategory);
        return new ResponseEntity<>(createdSubCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubCategory(@PathVariable("id") Long id, @RequestBody SubCategory subCategory) {
        try {
        	System.out.println("updateSubCategory: " + subCategory);
        	SubCategory existingSubCategory = subCategoryService.getSubCategoryById(id);
//        	if(existingSubCategory.getUrlSubCategory() != null && subCategory.getUrlSubCategory() != null && existingSubCategory.getUrlSubCategory() == (subCategory.getUrlSubCategory())) {
        	
        	subCategory.setId(id);
        	System.out.println("existingSubCategory: " + existingSubCategory);
            SubCategory updatedSubCategory = subCategoryService.updateSubCategory(subCategory);
            return new ResponseEntity<>(updatedSubCategory, HttpStatus.OK);
        } catch (NoSuchElementException e) {
//            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 404);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
        	
        	e.printStackTrace();	
//            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 500);
//          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        	
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubCategory(@PathVariable("id") Long id) {
        SubCategory existingSubCategory = subCategoryService.getSubCategoryById(id);
        if (existingSubCategory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        subCategoryService.deleteSubCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
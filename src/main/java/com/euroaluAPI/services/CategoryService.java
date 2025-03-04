package com.euroaluAPI.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.euroaluAPI.models.Category;
import com.euroaluAPI.repositories.CategoryRepository;
import com.euroaluAPI.response.ApiResponse;

@Service
public class CategoryService {
	 @Autowired
	    private CategoryRepository categoryRepository;

//	    public ApiResponse<List<Category>> getAllCategories() {
//	        ApiResponse<List<Category>> response = new ApiResponse<List<Category>>(200 ,"OK", categoryRepository.findAll());
//	    	return  response;
//	    }
	 public Object getAllCategories() {
		 return categoryRepository.findAll();
	 }

	    public Category getCategoryById(Long id) {
	        return categoryRepository.findById(id)
	                .orElseThrow(() -> new NoSuchElementException("Category not found: " + id));
	    }
//	    public Category getEvnetByIdStr(String id) {
//	    	return getCategoryById(Long.parseInt(id));
//	    }

	    public Category createCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    public Category updateCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    public void deleteCategory(Long id) {
	        categoryRepository.deleteById(id);
	    }
}

package com.euroaluAPI.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.euroaluAPI.models.SubCategory;
import com.euroaluAPI.repositories.SubCategoryRepository;

@Service
public class SubCategoryService {
	 @Autowired
	    private SubCategoryRepository subCategoryRepository;

	    public List<SubCategory> getAllCategories() {
	        return subCategoryRepository.findAll();
	    }

	    public SubCategory getSubCategoryById(Long id) {
	        return subCategoryRepository.findById(id)
	                .orElseThrow(() -> new NoSuchElementException("SubCategory not found: " + id));
	    }
//	    public SubCategory getEvnetByIdStr(String id) {
//	    	return getSubCategoryById(Long.parseInt(id));
//	    }

	    public SubCategory createSubCategory(SubCategory subCategory) {
	        return subCategoryRepository.save(subCategory);
	    }

	    public SubCategory updateSubCategory(SubCategory subCategory) {
	        return subCategoryRepository.save(subCategory);
	    }

	    public void deleteSubCategory(Long id) {
	        subCategoryRepository.deleteById(id);
	    }
}

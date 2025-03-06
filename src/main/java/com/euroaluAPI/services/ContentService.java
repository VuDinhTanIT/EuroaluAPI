package com.euroaluAPI.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.euroaluAPI.models.Content;
import com.euroaluAPI.repositories.ContentRepository;

import jakarta.validation.Valid;

@Service
public class ContentService {
	 @Autowired
	    private ContentRepository contentRepository;

	    public List<Content> getAllCategories() {
	        return contentRepository.findAll();
	    }

	    public Content getContentById(Long id) {
	        return contentRepository.findById(id)
	                .orElseThrow(() -> new NoSuchElementException("Content not found: " + id));
	    }

	    public Content createContent(@Valid Content content) {
	        return contentRepository.save(content);
	    }

	    public Content updateContent(@Valid Content content) {
	        return contentRepository.save(content);
	    }
	    public void deleteContent(Long id) {
	        contentRepository.deleteById(id);
	    }

		public Content getContentByPath(String path) {
			// TODO Auto-generated method stub
			return contentRepository.findByPath(path);
		}
}

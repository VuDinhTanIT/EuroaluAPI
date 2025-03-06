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

import com.euroaluAPI.models.Content;
import com.euroaluAPI.services.ContentService;


@RestController
@RequestMapping("api/admin/noi-dung")
public class ContentManagement{

    @Autowired
    private ContentService contentService;

    @GetMapping
    public ResponseEntity<List<Content>> getAllContents() {
        List<Content> contents = contentService.getAllCategories();
        return new ResponseEntity<>(contents, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getContentById(@PathVariable("id") Long id) {
        try {
            Content content = contentService.getContentById(id);
            return ResponseEntity.ok(content);
        } catch (NoSuchElementException e) {
//            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 404);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        } catch (Exception e) {
//            ErrorResponse errorResponse = new ErrorResponse("An error occurred", 500);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("/blog/{path}")
    public ResponseEntity<?> getContentByPath(@PathVariable("path") String path) {
        try {
            Content content = contentService.getContentByPath(path);
            return ResponseEntity.ok(content);
        } catch (NoSuchElementException e) {
//            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 404);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        } catch (Exception e) {
//            ErrorResponse errorResponse = new ErrorResponse("An error occurred", 500);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<Content> createContent(@RequestBody Content content) throws Exception {
        Content createdContent = contentService.createContent(content);
        return new ResponseEntity<>(createdContent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateContent(@PathVariable("id") Long id, @RequestBody  Content content) {
        try {
        	contentService.getContentById(id);        	
        	content.setId(id);
            Content updatedContent = contentService.updateContent(content);
            return new ResponseEntity<>(updatedContent, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
        	
        	e.printStackTrace();	
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        	
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable("id") Long id) {
        Content existingContent = contentService.getContentById(id);
        if (existingContent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        contentService.deleteContent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
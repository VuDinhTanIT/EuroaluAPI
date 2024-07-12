//package com.euroaluAPI.controllers.admin;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.euroaluAPI.models.Category;
//import com.euroaluAPI.services.CategoryService;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//@RestController
//@RequestMapping("api/admin/categorys")
//public class CategoryManagement{
//
//    @Autowired
//    private CategoryService categoryService;
// 
//
//    @GetMapping
//    public ResponseEntity<List<Category>> getAllCategories() {
//        List<Category> categorys = categoryService.getAllCategorysByOrderByUpdateTimeDesc();
//        return new ResponseEntity<>(categorys, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getCategoryById(@PathVariable("id") Long id) {
//        try {
//            Category category = categoryService.getCategoryById(id);
//            return ResponseEntity.ok(category);
//        } catch (NoSuchElementException e) {
////            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 404);
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
//        } catch (Exception e) {
////            ErrorResponse errorResponse = new ErrorResponse("An error occurred", 500);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<Category> createCategory(@RequestBody Category category, HttpServletRequest request) throws Exception {
//    	String categoryPath = "category_"+category.getId();
//    	QRData qrData = qRcode.generateQRcodeWithLogoO(category.getUrlCategory(), request, categoryPath);
//    	category.setQRCodeCategory(qrData.getNameQRcode());
//        Category createdCategory = categoryService.createCategory(category);
//        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateCategory(@PathVariable("id") Long id, @RequestBody Category category, HttpServletRequest request) {
//        try {
//        	System.out.println("updateCategory: " + category);
//        	Category existingCategory = categoryService.getCategoryById(id);
////        	if(existingCategory.getUrlCategory() != null && category.getUrlCategory() != null && existingCategory.getUrlCategory() == (category.getUrlCategory())) {
//        	String urlExCategory = existingCategory.getUrlCategory();
//        	String urlNewCategory = category.getUrlCategory();
//        	if( urlExCategory.charAt(urlExCategory.length() - 2) != (urlNewCategory.charAt(urlNewCategory.length() - 2))) {
//        		System.out.println("Cạp nhập Category: != urlCategory ");
//        		String categoryPath = "category_"+category.getId();
//        		QRData qrData = qRcode.generateQRcodeWithLogoO(category.getUrlCategory(), request, categoryPath);
//        		category.setQRCodeCategory(qrData.getNameQRcode());
//        	}
//        	category.setId(id);
//        	System.out.println("existingCategory: " + existingCategory);
//            Category updatedCategory = categoryService.updateCategory(category);
//            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 404);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//        } catch (Exception e) {
//        	
////        	e.printStackTrace();	
//            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 500);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
//        Category existingCategory = categoryService.getCategoryById(id);
//        if (existingCategory == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        categoryService.deleteCategory(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
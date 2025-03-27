package com.euroaluAPI.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.euroaluAPI.Utils.Utils;
import com.euroaluAPI.models.Product;
import com.euroaluAPI.models.ProductType;
import com.euroaluAPI.repositories.ProductRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ProductService {
	 @Autowired
	    private ProductRepository productRepository;

	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    public Product getProductById(Long id) {
	        return productRepository.findById(id)
	                .orElseThrow(() -> new NoSuchElementException("Product not found: " + id));
	    }

	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }
	    public void deleteProduct(Long id) {
	        productRepository.deleteById(id);
	    }

		public Product saveProduct(Product product, MultipartFile file, HttpServletRequest request) {
			// TODO Auto-generated method stub
			String newFileName = handleFileUpload(product, file, request);

		    if (newFileName != null) {
		        product.setImage(newFileName); // Cập nhật tên tệp tin trong đối tượng product
		    }
			return productRepository.save(product);
		}

		public boolean updateProduct(Product product, MultipartFile file, HttpServletRequest request) {
			// TODO Auto-generated method stub
			String newFileName = handleFileUpload(product, file, request);

		    if (newFileName != null) {
		        product.setImage(newFileName); // Cập nhật tên tệp tin trong đối tượng product
		    }
		    
			return productRepository.save(product)!=null;
		}
		private String handleFileUpload(Product product, MultipartFile file, HttpServletRequest request) {
		    if (file != null && !file.isEmpty()) {
		        try {
		            String newFileName = product.getName() + "_" + product.getCategory().getId() + ".jpg";
		            String applicationPath = request.getServletContext().getRealPath("");
		            String uploadFilePath = applicationPath + File.separator + Utils.UPLOAD_DIR;
		            File uploadFolder = new File(uploadFilePath);

		            if (!uploadFolder.exists()) {
		                uploadFolder.mkdir();
		            }

		            // Xóa tệp cũ nếu tên tệp mới khác tên tệp cũ
		            if (product.getImage() != null && !product.getImage().equals(newFileName)) {
		                File oldImageFile = new File(uploadFilePath + File.separator + product.getImage());
		                if (oldImageFile.exists()) {
		                    oldImageFile.delete(); // Xóa tệp cũ
		                }
		            }

		            // Lưu tệp tin mới
		            Files.copy(file.getInputStream(), new File(uploadFilePath + File.separator + newFileName).toPath(), StandardCopyOption.REPLACE_EXISTING);
		            return newFileName; // Trả về tên tệp mới
		        } catch (Exception e) {
		            System.err.println("Lỗi : " + e.getMessage());
		            e.printStackTrace();
		            // Xử lý ngoại lệ nếu có lỗi xảy ra
		        }
		    }
		    return null; // Nếu không có tệp tin mới, trả về null
		}

		public Product updateProduct(Product product) {
			return productRepository.save(product);
		}
		public List<ProductType> getAllProductTypes(){
			return productRepository.getAllProductType();
		}
		public List<Product> getProductsByProductTypeId(int productTypeId) {
	        return productRepository.getProductsByProductTypeId(productTypeId);
	    }
}

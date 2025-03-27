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
import com.euroaluAPI.models.Content;
import com.euroaluAPI.repositories.ContentRepository;

import jakarta.servlet.http.HttpServletRequest;
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

		public Content updateContent(Content content, MultipartFile file, HttpServletRequest request) {
			// TODO Auto-generated method stub
			String newFileName = handleFileUpload(content, file, request);
			if (newFileName != null)
				content.setImage(newFileName);
			return contentRepository.save(content);
		}

		public Content createContent(Content content, MultipartFile file, HttpServletRequest request) {
			String newFileName = handleFileUpload(content, file, request);
			if (newFileName != null)
				content.setImage(newFileName);
			return contentRepository.save(content);
		}
		private String handleFileUpload(Content content, MultipartFile file, HttpServletRequest request) {
			if (file != null && !file.isEmpty()) {
				try {
					String newFileName = content.getPath() + ".jpg";
					String applicationPath = request.getServletContext().getRealPath("");
					String uploadFilePath = applicationPath + File.separator + Utils.UPLOAD_DIR;
					File uploadFolder = new File(uploadFilePath);

					if (!uploadFolder.exists()) {
						uploadFolder.mkdir();
					}

					// Xóa tệp cũ nếu tên tệp mới khác tên tệp cũ
					if (content.getImage() != null && !content.getImage().equals(newFileName)) {
						File oldImageFile = new File(uploadFilePath + File.separator + content.getImage());
						if (oldImageFile.exists()) {
							oldImageFile.delete(); // Xóa tệp cũ
						}
					}
					Files.copy(file.getInputStream(), new File(uploadFilePath + File.separator + newFileName).toPath(),
							StandardCopyOption.REPLACE_EXISTING);
					return newFileName; // Trả về tên tệp mới
				} catch (Exception e) {
					System.err.println("Lỗi : " + e.getMessage());
					e.printStackTrace();
					// Xử lý ngoại lệ nếu có lỗi xảy ra
				}
			}
			return null; // Nếu không có tệp tin mới, trả về null
		}
}

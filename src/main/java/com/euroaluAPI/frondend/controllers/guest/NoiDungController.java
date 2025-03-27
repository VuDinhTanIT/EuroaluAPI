package com.euroaluAPI.frondend.controllers.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.euroaluAPI.models.Content;
import com.euroaluAPI.models.Product;
import com.euroaluAPI.services.ContentService;
import com.euroaluAPI.services.ProductService;

import jakarta.servlet.http.HttpServletRequest;



@Controller
public class NoiDungController {
	@Autowired
	private ContentService contentService;
	@Autowired ProductService productService;

	@GetMapping("/us/{path}")
	public String showIntroductioPage(ModelMap model, HttpServletRequest request, @PathVariable("path") String path) throws Exception {
//		String path = request.getRequestURI(); 
		Content content =  contentService.getContentByPath(path);
		model.addAttribute("content", content);	
		return "user/content"; // Returns the HTML template name
	}
	@GetMapping("/hinh-anh")
	public String showInCompanyImage(ModelMap model, HttpServletRequest request) throws Exception {
//		Content content =  contentService.getContentByPath(path);
		List<Product> hinhAnhCTys = productService.getProductsByProductTypeId(4);
		model.addAttribute("hinhAnhCtys", hinhAnhCTys);	
		return "user/hinh-anh-cty"; // Returns the HTML template name
	}
}
package com.euroaluAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping()
public class IndexController {
	@GetMapping("api/admin/index")
	public String name() {	
		String d = "hello";
		return d;
		
	}
	@GetMapping("index")
	public String index() {
		return "index";
	}
	@GetMapping("api/index")
	public String indexAPI() {
		return "indexAPI";
	}

}

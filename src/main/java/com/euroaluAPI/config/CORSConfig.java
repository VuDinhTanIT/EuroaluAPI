package com.euroaluAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {
	 	@Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
//	            	registry.addMapping("/**")
//	                .allowedOrigins("http://localhost:8081","http://localhost:8080", "https://training.vku.udn.vn", "http://192.168.10.8:3333") // Nguồn gốc cụ thể
//	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//	                .allowedHeaders("*")
//	                .allowCredentials(true);
	            	registry.addMapping("/**")
                    .allowedOriginPatterns("*")
                    .allowedMethods("GET","POST","PUT","DELETE")
                    .allowedHeaders("*")
                    .allowCredentials(true);
	                
	            }
	        };
	    }
}

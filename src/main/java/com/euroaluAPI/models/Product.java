package com.euroaluAPI.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoy_id")
	private Category category;	
	
	private int productType;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "sub_categoy_id", nullable = true)
//	private SubCategory subCategory;
	private double price;
	private String image;


	@Column(columnDefinition = "tinyInt(1)")
	private boolean status;

	// Getters, setters, constructors
}
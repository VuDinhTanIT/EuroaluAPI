package com.euroaluAPI.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.euroaluAPI.models.Product;
import com.euroaluAPI.models.ProductType;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

	@Query("SELECT P FROM ProductType P")
	List<ProductType> getAllProductType();
	
	@Query("SELECT P FROM Product P Where P.productType.id = :productTypeId")
	List<Product> getProductsByProductTypeId(int productTypeId);
	

}

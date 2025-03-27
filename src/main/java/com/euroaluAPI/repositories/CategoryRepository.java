package com.euroaluAPI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.euroaluAPI.models.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
	
	@Query("SELECT c FROM Category c WHERE c.parentId IS NULL AND c.id IN (SELECT c2.parentId.id FROM Category c2 WHERE c2.parentId.id IS NOT NULL)")
    List<Category> findCategoriesWithNoParentAndWithChildren();
	

}

package com.code.java.ProductManagerAPI.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.code.java.ProductManagerAPI.model.ProductModel;


public interface ProductRepository extends JpaRepository<ProductModel, Long>{
	
	
}

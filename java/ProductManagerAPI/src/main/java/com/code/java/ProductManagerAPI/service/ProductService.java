package com.code.java.ProductManagerAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.java.ProductManagerAPI.model.ProductModel;
import com.code.java.ProductManagerAPI.repo.ProductRepository;


@Service

public class ProductService {
	
	
	@Autowired
	private ProductRepository repo;
	
	
	public List<ProductModel> getAllProducts(){
		System.out.println(repo.findById((long) 29));
		return repo.findAll();
	}
	
	public ProductModel getProductById(Long id) {
		return repo.findById(id).get();
	}
	
	public ProductModel addProduct(ProductModel product) {
		return repo.save(product);
	}

	public void delete(Long id) {
		repo.deleteById(id);
		
	}
	
	
	
}

package com.code.java.ProductManagerAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.code.java.ProductManagerAPI.model.ProductModel;
import com.code.java.ProductManagerAPI.service.ProductService;


@RestController
@CrossOrigin(origins = "*")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	//@ResponseBody
	public List<ProductModel> getAllProducts() {
		System.out.println("Inside controller");
		List<ProductModel> productlist = service.getAllProducts();
		return productlist;
		
	}
	
	@GetMapping("/product/{id}")
	@ResponseBody
	public ProductModel getProductById(@PathVariable("id") Long id) {
		return service.getProductById(id);
	}
	
	@PostMapping("/add")
	public ProductModel addProduct(@RequestBody ProductModel product) {
		System.out.println(product.getName());
		return service.addProduct(product);
	}
	
	@PutMapping("/update/{id}")
	public ProductModel updateProduct(@PathVariable("id") Long id, @RequestBody ProductModel product) {
		System.out.println(product.getId()+ product.getName());
		product.setId(id);
		return service.addProduct(product);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") Long id, ProductModel product) {
		try {
			System.out.println("Inside delete");
			product.setId(id);
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}

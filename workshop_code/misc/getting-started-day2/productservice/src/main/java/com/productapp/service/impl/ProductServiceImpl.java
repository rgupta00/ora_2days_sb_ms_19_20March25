package com.productapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productapp.entities.Product;
// if i need to change the impl from map to jdbc
//do i have to change my code?
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.ProductRepo;
import com.productapp.service.ProductService;

import lombok.extern.log4j.Log4j2;
//BL= FR +NFR
@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	private ProductRepo repo;
	
	public ProductServiceImpl(ProductRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<Product> getAll() {
		log.info("productservice get all method is called");
		return repo.findAll();
	}

	@Override
	public Product getProductById(int productId) {
		Product product= repo.findById(productId)
				.orElseThrow(()-> new ProductNotFoundException("product with id "+ productId +" is not found"));
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		repo.save(product);
		return product;
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		Product productToUpdate= getProductById(productId);
		productToUpdate.setPrice(product.getPrice());
		repo.save(productToUpdate);
		
		return productToUpdate;
	}

	@Override
	public Product deleteProduct(int productId) {
		Product productToDelete= getProductById(productId);
		repo.delete(productToDelete);
		return productToDelete;
	}

}

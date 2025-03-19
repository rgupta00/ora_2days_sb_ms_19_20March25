package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
// if i need to change the impl from map to jdbc
//do i have to change my code?
import com.productapp.exceptions.ProductNotFoundException;

import lombok.extern.log4j.Log4j2;
//BL= FR +NFR
@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	
	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAll() {
		log.info("productservice get all method is called");
		return productDao.getAll();
	}

	@Override
	public Product getProductById(int productId) {
		Product product= productDao.getProductById(productId);
		if(product==null) {
			throw new ProductNotFoundException("product with id "+ productId+" is not found");
		}
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		
		return productDao.updateProduct(productId, product);
	}

	@Override
	public Product deleteProduct(int productId) {
		return productDao.deleteProduct(productId);
	}

}

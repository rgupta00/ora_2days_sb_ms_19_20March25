package com.productapp.dao.impl;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
import com.productapp.exceptions.ProductNotFoundException;
@Repository
public class ProductDaoImplUsingJdbc implements ProductDao{
	private static Map<Integer, Product> products=new HashMap<Integer, Product>();
	private static int counter;
	static {
		products.put(1, new Product(1, "Laptop", BigDecimal.valueOf(500000)));
		products.put(2, new Product(2, "Laptop cover", BigDecimal.valueOf(400)));
		counter=2;
	}
	
	@Override
	public List<Product> getAll() {	
		System.out.println("---using jdbc----");
		return new ArrayList<Product>(products.values());
	}

	@Override
	public Product getProductById(int productId) {
		Product product= products.get(productId);
		if(product==null)
			throw new ProductNotFoundException("product with id "+ productId +" is not found");
		
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		product.setId(++counter);
		products.put(product.getId(), product);
		return product;
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		Product productToUpdate= getProductById(productId);
		productToUpdate.setPrice(product.getPrice());
		products.put(productId, productToUpdate);
		
		return productToUpdate;
	}

	@Override
	public Product deleteProduct(int productId) {
		Product productToDelete=getProductById(productId);
		products.remove(productId);
		return productToDelete;
	}

}

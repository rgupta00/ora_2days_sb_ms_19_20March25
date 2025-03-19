package com.productapp.config;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.productapp.entities.Product;
import com.productapp.repo.ProductRepo;

@Configuration
public class DbInit implements CommandLineRunner{

	@Autowired
	private ProductRepo productRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("------------------------------------------------");
		productRepo.save(new Product("laptop", BigDecimal.valueOf(100000.00)));
		productRepo.save(new Product("laptop cover", BigDecimal.valueOf(400.00)));
	
		
		
	}

}

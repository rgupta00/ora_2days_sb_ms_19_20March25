package com.productapp.config;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.productapp.entities.Coupon;
import com.productapp.entities.Product;
import com.productapp.repo.CouponRepo;
import com.productapp.repo.ProductRepo;

@Configuration
public class DbInit implements CommandLineRunner{

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CouponRepo couponRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("------------------------------------------------");
		productRepo.save(new Product("laptop", BigDecimal.valueOf(100000.00),"foo@gmail.com"));
		productRepo.save(new Product("laptop cover", BigDecimal.valueOf(400.00),"bar@gmail.com"));
		
		couponRepo.save(new Coupon("SUP10", 0.10));
		couponRepo.save(new Coupon("SUP20", 0.20));
		couponRepo.save(new Coupon("SUP15", 0.15));
		
		
	}

}

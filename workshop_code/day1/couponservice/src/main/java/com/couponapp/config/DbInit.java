package com.couponapp.config;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.couponapp.entities.Coupon;
import com.couponapp.entities.Product;
import com.couponapp.repo.CouponRepo;
import com.couponapp.repo.ProductRepo;

@Configuration
public class DbInit implements CommandLineRunner{

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CouponRepo couponRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("------------------------------------------------");
		productRepo.save(new Product("laptop", BigDecimal.valueOf(100000.00)));
		productRepo.save(new Product("laptop cover", BigDecimal.valueOf(400.00)));
		
		couponRepo.save(new Coupon("SUP10", 0.10));
		couponRepo.save(new Coupon("SUP20", 0.20));
		couponRepo.save(new Coupon("SUP15", 0.15));
		
		
	}

}

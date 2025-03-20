package com.couponapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.couponapp.entities.Coupon;
import com.couponapp.repo.CouponRepo;

@Configuration
public class DbInit implements CommandLineRunner{

	
	@Autowired
	private CouponRepo couponRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("------------------------------------------------");
		
		couponRepo.save(new Coupon("SUP10", 0.10));
		couponRepo.save(new Coupon("SUP20", 0.20));
		couponRepo.save(new Coupon("SUP15", 0.15));
		
		
	}

}

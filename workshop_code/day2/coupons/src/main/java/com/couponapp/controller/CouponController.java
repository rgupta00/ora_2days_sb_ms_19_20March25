package com.couponapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.couponapp.entities.Coupon;
import com.couponapp.service.CouponService;
@RefreshScope
@RestController
@CrossOrigin("*")
public class CouponController {
	
	private CouponService couponService;

	@Value("${data.info}")
	private String info;
	
	@GetMapping(path="info")
	public String info() {
		return info;
	}
	
	@Autowired
	public CouponController(CouponService couponService) {
		this.couponService = couponService;
	}

	@PostMapping(path="coupons")
	public Coupon addCoupon(@RequestBody Coupon coupon) {
		System.out.println("---------------------");
		System.out.println(coupon);
		return couponService.addCoupon(coupon);
	}
	
	//get the copoon object once somebody pass couponCode
	@GetMapping(path="coupons/{couponCode}")
	public Coupon getCouponByCode(@PathVariable String couponCode) {
		System.out.println("-------------------1------------------");
		return couponService.findByDiscountCoupon(couponCode);
	}

}

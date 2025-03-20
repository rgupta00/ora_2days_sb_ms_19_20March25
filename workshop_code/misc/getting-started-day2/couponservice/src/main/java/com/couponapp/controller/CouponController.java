package com.couponapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.couponapp.entities.Coupon;
import com.couponapp.service.CouponService;


@RestController
@CrossOrigin("*")
public class CouponController {
	
	private CouponService couponService;

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
		return couponService.findByDiscountCoupon(couponCode);
	}
}

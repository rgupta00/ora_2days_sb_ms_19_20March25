package com.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.service.CouponService;

@RestController
@CrossOrigin("*")
public class CouponController {
	
	private CouponService couponCode;

	@Autowired
	public CouponController(CouponService couponCode) {
		this.couponCode = couponCode;
	}
	
	//code to add the coupon
	
	//get the copoon object once somebody pass couponCode

}

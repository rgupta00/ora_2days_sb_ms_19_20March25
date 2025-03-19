package com.productapp.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.productapp.dto.Coupon;
//
//@FeignClient(name = "coupons", url = "http://localhost:8083")

@FeignClient("COUPONS")
public interface CouponServiceProxy {
	@PostMapping(path="coupons")
	public Coupon addCoupon(@RequestBody Coupon coupon) ;
	
	@GetMapping(path="coupons/{couponCode}")
	public Coupon getCouponByCode(@PathVariable String couponCode);
}

package com.productapp.proxy;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.productapp.dto.Coupon;
@Service
public class CouponServiceFallBack implements CoponServiceProxy{

	@Override
	public Coupon addCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coupon getCouponByCode(String couponCode) {
		return Coupon.builder().discountCoupon(couponCode).discount(0.05).expiration(LocalDateTime.now()).build();
	}

}

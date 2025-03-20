package com.couponapp.service;

import com.couponapp.entities.Coupon;

public interface CouponService {

	public Coupon findByDiscountCoupon(String discountCoupon);
	public Coupon addCoupon(Coupon coupon);
}

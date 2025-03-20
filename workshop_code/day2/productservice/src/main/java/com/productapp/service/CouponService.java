package com.productapp.service;

import com.productapp.entities.Coupon;

public interface CouponService {

	public Coupon findByDiscountCoupon(String discountCoupon);
	public Coupon addCoupon(Coupon coupon);
}

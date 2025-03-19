package com.productapp.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.entities.Coupon;
import com.productapp.repo.CouponRepo;
import com.productapp.service.CouponService;
@Service
public class CouponServiceImpl implements CouponService{

	private CouponRepo couponRepo;
	
	@Autowired
	public CouponServiceImpl(CouponRepo couponRepo) {
		this.couponRepo = couponRepo;
	}

	@Override
	public Coupon findByDiscountCoupon(String discountCoupon) {
		return couponRepo.findByDiscountCoupon(discountCoupon);
	}

	@Override
	public Coupon addCoupon(Coupon coupon) {
		coupon.setExpiration(LocalDateTime.now().plusDays(2));
		couponRepo.save(coupon);
		return coupon;
	}

}

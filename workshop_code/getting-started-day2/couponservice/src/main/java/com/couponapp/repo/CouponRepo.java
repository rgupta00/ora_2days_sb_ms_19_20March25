package com.couponapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.couponapp.entities.Coupon;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Integer> {
	public Coupon findByDiscountCoupon(String discountCoupon);
}

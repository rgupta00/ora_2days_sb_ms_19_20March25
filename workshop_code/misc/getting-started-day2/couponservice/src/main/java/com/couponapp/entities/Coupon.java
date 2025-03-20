package com.couponapp.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="coupon_table")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String discountCoupon;
	
	private double discount;
	
	private LocalDateTime expiration;

	public Coupon(String discountCoupon, double discount) {
		this.discountCoupon = discountCoupon;
		this.discount = discount;
		this.expiration=LocalDateTime.now().plusDays(2);
	}

}

package com.productapp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
	private Integer id;
	

	private String discountCoupon;
	
	private double discount;
	
	private LocalDateTime expiration;


}

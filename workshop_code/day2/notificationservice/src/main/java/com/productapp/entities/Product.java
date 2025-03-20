package com.productapp.entities;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
//DTO: data tansfer object

@Data
@NoArgsConstructor

public class Product  {
	private Integer id;
	private String name;
	
	private BigDecimal price;

	private String discountCoupon;
	private BigDecimal discountedPrice;
	private String email;
	

	public Product(String name,
			 BigDecimal price, String email) {
		super();
		this.name = name;
		this.price = price;
		this.email=email;
	}
	
	
	
}

package com.productapp.entities;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
//DTO: data tansfer object

@Data
@NoArgsConstructor

@Entity
@Table(name="product_table")
public class Product  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="p_name")
	@NotNull(message = "{product.name.absent}")
	private String name;
	
	@NotNull(message = "{product.price.absent}")
	@Range(min = 10, max = 100000, message = "{product.price.invalid}")
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

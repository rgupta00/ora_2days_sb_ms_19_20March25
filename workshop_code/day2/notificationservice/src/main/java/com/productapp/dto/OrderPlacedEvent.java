package com.productapp.dto;

import com.productapp.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPlacedEvent {
	private Product product;
	private String email;
}

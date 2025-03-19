package com.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients("com.productapp.proxy")
@SpringBootApplication
public class Productappv1Application {

	public static void main(String[] args) {
		SpringApplication.run(Productappv1Application.class, args);
	}

}

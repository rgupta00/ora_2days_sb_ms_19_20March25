package com.eureakservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class EureakserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EureakserviceApplication.class, args);
	}

}

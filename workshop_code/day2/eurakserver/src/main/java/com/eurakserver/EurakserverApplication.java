package com.eurakserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class EurakserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurakserverApplication.class, args);
	}

}

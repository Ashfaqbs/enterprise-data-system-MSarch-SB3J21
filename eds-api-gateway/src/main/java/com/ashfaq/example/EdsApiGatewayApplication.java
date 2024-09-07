package com.ashfaq.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EdsApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdsApiGatewayApplication.class, args);
	}

}

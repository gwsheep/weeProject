package com.jproject.wee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeeApplication.class, args);
	}

}

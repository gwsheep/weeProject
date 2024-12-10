package com.jproject.weeEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WeeEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeeEurekaApplication.class, args);
	}

}

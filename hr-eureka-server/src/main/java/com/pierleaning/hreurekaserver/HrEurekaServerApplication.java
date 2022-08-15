package com.pierleaning.hreurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // habilita a aplicação como um servidor eureka
@SpringBootApplication
public class HrEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrEurekaServerApplication.class, args);
	}

}

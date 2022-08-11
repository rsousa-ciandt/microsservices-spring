package com.ricardo.hrworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient // torna a aplicação como um cliente do eureka
@SpringBootApplication
public class HrWorkerApplication {
	public static void main(String[] args) {
		SpringApplication.run(HrWorkerApplication.class, args);
	}

}

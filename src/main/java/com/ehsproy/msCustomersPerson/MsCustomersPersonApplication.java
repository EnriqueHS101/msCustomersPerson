package com.ehsproy.msCustomersPerson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;


@EnableEurekaClient
@SpringBootApplication
@EnableReactiveMongoRepositories
public class MsCustomersPersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCustomersPersonApplication.class, args);
	}

}

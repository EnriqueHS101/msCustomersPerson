package com.ehsproy.msCustomersPerson.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
//	@Value("http://localhost:8087/account")
//	private String url;
	
	@Bean
	public WebClient registrarWebClient(){
		return WebClient.create("http://localhost:8090");
	}
}

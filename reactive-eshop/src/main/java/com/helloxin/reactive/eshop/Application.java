package com.helloxin.reactive.eshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Application {
	static final Logger LOG = LoggerFactory
			.getLogger(Application.class);
	
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
		
	
	}
	
	@Bean
	WebClient webClient() {
		return WebClient
			.create("http://localhost:8080")
			.mutate()
			.build();
	}
}

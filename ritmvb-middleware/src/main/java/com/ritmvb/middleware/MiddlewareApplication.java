package com.ritmvb.middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiddlewareApplication {

	public static final String clientURL = "http://localhost:8081";
	public static final String serverURL = "http://localhost:8080";

	public static void main(String[] args) {
		SpringApplication.run(MiddlewareApplication.class, args);
	}

}
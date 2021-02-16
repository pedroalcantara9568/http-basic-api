package com.example.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext context = SpringApplication.run(JwtApplication.class, args);



	}

}

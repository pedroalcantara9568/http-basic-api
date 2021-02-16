package com.example.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext context = SpringApplication.run(BasicApplication.class, args);



	}

}

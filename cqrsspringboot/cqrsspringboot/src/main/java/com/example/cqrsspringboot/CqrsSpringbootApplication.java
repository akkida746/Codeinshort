package com.example.cqrsspringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CqrsSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CqrsSpringbootApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			System.out.println("Started..");
		};
	}

}

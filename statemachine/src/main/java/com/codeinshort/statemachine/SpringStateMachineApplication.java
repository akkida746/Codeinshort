package com.codeinshort.statemachine;

import com.codeinshort.statemachine.service.StateMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringStateMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStateMachineApplication.class, args);
	}

	@Autowired
	private StateMachineService service;

	@Bean
	CommandLineRunner runner (){
		return args -> {
			System.out.println("Started..");

			service.startMachine();
		};
	}

}

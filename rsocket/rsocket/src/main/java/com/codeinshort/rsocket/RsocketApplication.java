package com.codeinshort.rsocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class RsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsocketApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			log.info("Started..");
		};
	}

}

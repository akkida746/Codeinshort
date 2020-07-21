package com.codeinshort.rsocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class RsocketServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsocketServerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			log.info("Rsocket Server Started..");
		};
	}

}

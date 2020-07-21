package com.codeinshort.rsocketclient;

import com.codeinshort.rsocketclient.entity.Message;
import com.codeinshort.rsocketclient.entity.RSocketClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.rsocket.RSocketRequester;
import reactor.core.publisher.Flux;
import sun.tools.jar.CommandLine;

@Slf4j
@SpringBootApplication
public class RsocketclientApplication {

	@Autowired
	private RSocketRequester rSocketRequester;

	public static void main(String[] args) {
		SpringApplication.run(RsocketclientApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			log.info("Started RSocket Client");

			RSocketClient rSocketClient = new RSocketClient(rSocketRequester);
			Flux<Message> messages = rSocketClient.getUserMessage("akash");
			messages.take(2).doOnNext(p -> log.info(p.getMsg())).blockLast();
		};
	}

}

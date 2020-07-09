package com.codeinshort.messagerouting;

import com.codeinshort.messagerouting.component.JmsProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class ActiveMqJmsExample {

    @Autowired
    private JmsProducer jmsProducer;

	public static void main(String[] args) {
		SpringApplication.run(ActiveMqJmsExample.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			log.info("Started..");
			log.info("Sending msg..");
			jmsProducer.sendMsg("inbound.queue", "Hello World !");
			log.info("Msg sent..");
		};
	}

}

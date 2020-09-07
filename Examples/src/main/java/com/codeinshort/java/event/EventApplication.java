package com.codeinshort.java.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventApplication.class, args);

    }

    @Autowired
    private Publisher publisher;

    @Bean
    CommandLineRunner runner(){
        return args -> {
            System.out.println("Sending events..");
            publisher.publishEvent("Hello Akash!");
        };
    }
}

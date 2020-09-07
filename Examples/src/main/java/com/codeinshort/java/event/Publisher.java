package com.codeinshort.java.event;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    private ApplicationEventPublisher publisher;

    public Publisher(ApplicationEventPublisher publisher){
        this.publisher = publisher;
    }

    public void publishEvent(final String message){
        System.out.println("Publishing message: " + message);
        CustomEvent event = new CustomEvent(this, message);
        publisher.publishEvent(event);
    }
}

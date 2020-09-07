package com.codeinshort.java.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @Async
    @EventListener
    public void handleEvent(CustomEvent event){
        System.out.println("Received event: "+ event.getMessage());
    }
}

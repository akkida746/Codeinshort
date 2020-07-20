package com.codeinshort.rsocket.service;

import com.codeinshort.rsocket.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class MessageService {

    private static final Map<String, String> messages = new HashMap<>();

    {
        messages.put("akash","This is the first demo tweet");
        messages.put("deep","This is the second demo tweet");
    }

    public Flux<Message> getUserMessage(String user){
        log.info("Inside getUserMessage()");
        log.info("message: " + messages.get(user));
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1)).map(i -> new Message(user, messages.get(user)));
    }
}

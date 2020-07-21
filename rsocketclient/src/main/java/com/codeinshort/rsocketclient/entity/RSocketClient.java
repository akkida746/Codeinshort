package com.codeinshort.rsocketclient.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.rsocket.RSocketRequester;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.time.Duration;

@Slf4j
public class RSocketClient {

    private RSocketRequester rSocketRequester;

    public RSocketClient(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }

    public Flux<Message> getUserMessage(String user) {
        log.info("RSocket RSocketClient");
        return rSocketRequester.route("message.by.user").data(user).retrieveFlux(Message.class)
                .retryBackoff(5, Duration.ofSeconds(1), Duration.ofSeconds(20))
                .doOnError(IOException.class, e -> log.error(e.getMessage()));
    }
}

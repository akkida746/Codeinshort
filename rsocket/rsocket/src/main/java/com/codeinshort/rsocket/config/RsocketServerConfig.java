package com.codeinshort.rsocket.config;

import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import reactor.core.publisher.Mono;

import java.net.URI;

@Configuration
public class RsocketServerConfig {

    @LocalServerPort
    private int port;

    @Bean
    public Mono<RSocketRequester> rSocketRequester(RSocketStrategies rSocketStrategies, RSocketProperties rSocketProperties){
        return RSocketRequester.builder().rsocketStrategies(rSocketStrategies).connectWebSocket(getURI(rSocketProperties));
    }

    private URI getURI(RSocketProperties rSocketProperties){
        return URI.create(String.format("ws://localhost:%d%s",
                port, rSocketProperties.getServer().getMappingPath()));
    }
}

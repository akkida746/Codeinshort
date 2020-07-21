package com.codeinshort.rsocketclient.config;

import com.codeinshort.rsocketclient.entity.RSocketClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

@Configuration
public class RSocketClientConfig {

    @Bean
    public RSocketClient rSocketClient(RSocketRequester rSocketRequester){
        return new RSocketClient(rSocketRequester);
    }

    @Bean
    public RSocketRequester rSocketRequester(RSocketRequester.Builder builder){
        return builder.connectTcp("localhost",8080).block();
    }
}

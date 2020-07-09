package com.codeinshort.camelrouting.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class JmsRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("{{input.queue}}")
                .log("New message received")
                .process(exchange -> {
                    String convertedMessage = exchange.getMessage().getBody() + " is converted";
                    exchange.getMessage().setBody(convertedMessage);
                })
                .to("{{output.queue}}")
                .log("Message is successfully sent to the output queue")
                .end();

    }
}

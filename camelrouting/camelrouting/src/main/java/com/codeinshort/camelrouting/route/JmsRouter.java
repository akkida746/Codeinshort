package com.codeinshort.camelrouting.route;

import com.google.common.collect.Lists;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JmsRouter extends RouteBuilder {

    private final String msgUrl = "http://localhost:8081/message/";

    @Override
    public void configure() throws Exception {

        final List<String> msgList = Lists.newArrayList();

        from("{{input.queue}}")
                .log("New message received")
                .process(exchange -> {
                    String convertedMessage = exchange.getMessage().getBody() + " is converted";
                    log.info("Recevied Msg: " + exchange.getMessage().getBody());
                    exchange.getMessage().setBody(convertedMessage);
                    msgList.add(convertedMessage);
                    System.out.println(msgList.get(0));
                })
                .to("{{output.queue}}")
                .log("Message is successfully sent to the output queue")
                .end();

    }
}

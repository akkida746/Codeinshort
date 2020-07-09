package com.codeinshort.rsocket.contoller;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @Autowired
    private RSocketRequester rSocketRequester;

    @GetMapping(value = "/echo/{message}")
    public Publisher<String> echo(@PathVariable("message") String msg){
        return rSocketRequester.route("requestresponse").data(msg).retrieveMono(String.class);
    }
}

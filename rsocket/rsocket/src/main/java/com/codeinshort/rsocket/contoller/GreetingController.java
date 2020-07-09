package com.codeinshort.rsocket.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(){
        return "Greeting !";
    }

    @GetMapping("/service")
    public Mono<String> service(String request){
        return Mono.just(request);
    }
}

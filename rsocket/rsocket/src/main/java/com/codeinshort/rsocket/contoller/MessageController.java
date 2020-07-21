package com.codeinshort.rsocket.contoller;

import com.codeinshort.rsocket.entity.Message;
import com.codeinshort.rsocket.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private Mono<RSocketRequester> rSocketRequester;

    @GetMapping(value = "/message/{user}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> getMessageByUser(@PathVariable String user) {
        log.info("Inside getMessageByUser()");
        log.info("Getting message for user: " + user);
        return messageService.getUserMessage(user);
    }

    @GetMapping(value = "/rsocket/{user}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> getByUserViaRsocket(@PathVariable String user) {
        return rSocketRequester.flatMapMany(r -> r.route("message.by.user").data(user).retrieveFlux(Message.class));
    }
}

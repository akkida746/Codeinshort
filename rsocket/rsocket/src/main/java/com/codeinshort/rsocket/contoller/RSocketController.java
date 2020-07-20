package com.codeinshort.rsocket.contoller;

import com.codeinshort.rsocket.entity.Message;
import com.codeinshort.rsocket.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class RSocketController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("message.by.user")
    public Flux<Message> getByUser(String user){
        return messageService.getUserMessage(user);
    }
}

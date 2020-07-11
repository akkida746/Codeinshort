package com.codeinshort.camelrouting.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MessageController {

    @GetMapping("/message/{msg}")
    public String receiveMsg(@PathVariable String msg){
        log.info("Inside MessageController receiveMsg()..");
        log.info("Msg: " + msg);
        return msg;
    }
}

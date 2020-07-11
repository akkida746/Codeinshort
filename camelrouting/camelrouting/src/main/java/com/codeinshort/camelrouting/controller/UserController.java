package com.codeinshort.camelrouting.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @GetMapping("/user")
    public void greetUser(){
        log.info("User is greeted!");
    }
}

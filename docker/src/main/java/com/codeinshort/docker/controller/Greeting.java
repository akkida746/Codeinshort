package com.codeinshort.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class Greeting {

    @GetMapping("/user")
    public String greetingUser(){
        return "Welcome!";
    }
}

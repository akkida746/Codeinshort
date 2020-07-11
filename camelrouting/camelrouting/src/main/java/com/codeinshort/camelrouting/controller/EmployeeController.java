package com.codeinshort.camelrouting.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public void employeeGreet(){
        log.info("Employee is greeted!");
    }
}

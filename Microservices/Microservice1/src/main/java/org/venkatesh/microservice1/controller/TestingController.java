package org.venkatesh.microservice1.controller;


import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {

    private final Environment environment;

    public TestingController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/get-info")
    public String getInfo(){
        String portNumber = environment.getProperty("server.port");
        return "This is the micro service 1  " + portNumber;
    }
}

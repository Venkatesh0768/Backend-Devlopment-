package org.venkatesh.microservice2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.venkatesh.microservice2.service.TestingService;

@RestController
public class TestController1 {

    private final TestingService testingService;

    public TestController1(TestingService testingService) {
        this.testingService = testingService;
    }

    @GetMapping("/get-info2")
    public String getInfo2(){
        return testingService.getInfo2();
    }
}

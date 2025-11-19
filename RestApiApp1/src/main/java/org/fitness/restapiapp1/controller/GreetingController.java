package org.fitness.restapiapp1.controller;

import org.apache.coyote.Response;
import org.fitness.restapiapp1.service.GreetingService;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GreetingController {

    private final GreetingService service;


    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @GetMapping("/greet/{wish}")
    public ResponseEntity<String> getGreeting(@PathVariable  String wish){
        return ResponseEntity.ok(service.greetingish(wish));
    }
}

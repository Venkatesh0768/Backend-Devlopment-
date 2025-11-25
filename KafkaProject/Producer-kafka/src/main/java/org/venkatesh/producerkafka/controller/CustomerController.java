package org.venkatesh.producerkafka.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.venkatesh.producerkafka.model.Customer;
import org.venkatesh.producerkafka.service.CustomerService;

@RestController
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public String register(@RequestBody Customer customer){
        return service.registerCx(customer);
    }
}

package org.fitness.restapiapp1.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String greetingish(String wish){
        return "WElcome to the wish " + wish;
    }
}

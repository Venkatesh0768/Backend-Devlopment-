package org.spring.gobalexceptionspring.controller;

import org.spring.gobalexceptionspring.model.Tourist;
import org.spring.gobalexceptionspring.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
        String response  = touristService.registerTourist(tourist);
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }
}

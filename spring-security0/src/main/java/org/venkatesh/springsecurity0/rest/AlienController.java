package org.venkatesh.springsecurity0.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.venkatesh.springsecurity0.model.Alien;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlienController {

    @GetMapping("/get-all")
    public List<Alien> getAll() {
        List<Alien> list = new ArrayList<>(List.of(new Alien(1, "venky", "surat"), new Alien(2, "akash", "Uganda")));
        return list;
    }

    @PostMapping("/register")
    public void register(@RequestBody Alien alien){
        System.out.println(alien);
    }
}

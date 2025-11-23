package org.venkatesh.springsecurity1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.venkatesh.springsecurity1.model.User;
import org.venkatesh.springsecurity1.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registeUser(@RequestBody User user){
        return new ResponseEntity<>(userService.register(user) , HttpStatus.CREATED);
    }

    @GetMapping("/get-user")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
}

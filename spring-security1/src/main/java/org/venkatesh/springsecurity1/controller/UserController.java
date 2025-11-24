package org.venkatesh.springsecurity1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.venkatesh.springsecurity1.model.User;
import org.venkatesh.springsecurity1.service.JwtTokenService;
import org.venkatesh.springsecurity1.service.UserService;

import java.util.List;

@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtService;

    @GetMapping
    public String checkOauth(){
        return "Oauth is Working";
    }

    public UserController(UserService userService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtTokenService jwtService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @GetMapping("/login/{username}/{password}")
    public String loginUser(
            @PathVariable String username,
            @PathVariable String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(username );
        }
        return "Invalid User";
    }


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
    }

    @GetMapping("/get-user")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
}

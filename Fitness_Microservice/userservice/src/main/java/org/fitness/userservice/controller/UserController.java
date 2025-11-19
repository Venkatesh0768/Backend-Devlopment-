package org.fitness.userservice.controller;

import jakarta.validation.Valid;
import org.fitness.userservice.dtos.UserRequestDto;
import org.fitness.userservice.dtos.UserResponseDto;
import org.fitness.userservice.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody UserRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registerUser(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUser() {
        return ResponseEntity.ok(service.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserId(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable UUID id, @Valid @RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(service.updateUser(userRequestDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id) {
        return ResponseEntity.ok(service.deleteUser(id));
    }


}

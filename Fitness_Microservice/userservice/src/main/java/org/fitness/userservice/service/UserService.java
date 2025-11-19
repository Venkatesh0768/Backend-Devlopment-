package org.fitness.userservice.service;

import org.fitness.userservice.dtos.UserRequestDto;
import org.fitness.userservice.dtos.UserResponseDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponseDto registerUser(UserRequestDto requestDto);
    List<UserResponseDto> getAllUser();
    UserResponseDto getUserById(UUID id);
    UserResponseDto updateUser(UserRequestDto requestDto , UUID id);
    String deleteUser(UUID id);
    Boolean isValidUser(UUID uuid);
}

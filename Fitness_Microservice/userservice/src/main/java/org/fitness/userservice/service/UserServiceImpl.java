package org.fitness.userservice.service;

import lombok.extern.slf4j.Slf4j;
import org.fitness.userservice.dtos.UserRequestDto;
import org.fitness.userservice.dtos.UserResponseDto;
import org.fitness.userservice.enums.userRole;
import org.fitness.userservice.model.User;
import org.fitness.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserResponseDto registerUser(UserRequestDto requestDto) {
        if (repository.existsByEmail(requestDto.getEmail())) {
            throw new RuntimeException("User already Exits");
        }
        User user = User.builder()
                .firstName(requestDto.getFirstName())
                .lastName(requestDto.getLastName())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .role(userRole.USER)
                .build();

        User savedUser = repository.save(user);
        log.info("User Register : {}", savedUser.getEmail());

        return mapToDto(savedUser);
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();

    }

    @Override
    public UserResponseDto getUserById(UUID id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        return mapToDto(user);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto requestDto,UUID id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());

        User updatedUser = repository.save(user);
        return mapToDto(updatedUser);

    }

    @Override
    public String deleteUser(UUID id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        repository.delete(user);
        return "User Deleted SuccessFully";
    }

    @Override
    public Boolean isValidUser(UUID id) {
        return repository.existsById(id);
    }

    private UserResponseDto mapToDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}

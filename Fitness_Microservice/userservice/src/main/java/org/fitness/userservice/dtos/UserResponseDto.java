package org.fitness.userservice.dtos;

import lombok.*;
import org.fitness.userservice.enums.userRole;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    private UUID id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private userRole role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

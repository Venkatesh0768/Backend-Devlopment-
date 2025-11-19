package org.fitness.userservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {
    @NotBlank(message = "The Email Should Not be Blank")
    @Email(message = "Enter the valid Email Address")
    private String email;

    @NotBlank(message = "The Password Should Not be Blank")
    @Size(min = 6, message = "The Password Should be min of 6 Letter")
    private String password;
    private String firstName;
    private String lastName;
}

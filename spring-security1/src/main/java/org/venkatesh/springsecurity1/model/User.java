package org.venkatesh.springsecurity1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.venkatesh.springsecurity1.service.UserService;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private Integer Id;
    private String email;
    private String password;


}

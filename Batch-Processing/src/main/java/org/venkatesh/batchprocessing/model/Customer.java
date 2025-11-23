package org.venkatesh.batchprocessing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Customer {
    @Id
    private Integer customerId;
    private String firstName;
    private String lastName;
    private  String email;
    private Long phone;
    private String city;
    private String state;
    private Integer zipcode;
    private String country;


}

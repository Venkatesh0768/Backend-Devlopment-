package org.venkatesh.ticketbookingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger extends RepresentationModel {
    @Id
    private Integer pid;
    private String name ;
    private String departure;
    private String arrival;
    private LocalDateTime dateOfJourney;
}

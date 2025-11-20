package org.venkatesh.ticketbookingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    private Integer ticketNumber;
    private String status;
    private Double ticketPrice;
    private String name ;
    private String departure;
    private String arrival;
    private LocalDateTime dateOfJourney;
}

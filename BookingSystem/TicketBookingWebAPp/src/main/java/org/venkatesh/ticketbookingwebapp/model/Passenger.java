package org.venkatesh.ticketbookingwebapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger {
    private Integer pid;
    private String name;
    private String departure;
    private String arrival;
    private LocalDateTime dateOfJourney;
}

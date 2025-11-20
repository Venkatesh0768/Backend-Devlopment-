package org.venkatesh.ticketbookingapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.venkatesh.ticketbookingapp.model.Passenger;
import org.venkatesh.ticketbookingapp.model.Ticket;
import org.venkatesh.ticketbookingapp.service.TicketBookingService;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "This apis For Ticket Booking api")
public class TicketController {
    private final TicketBookingService service;

    public TicketController(TicketBookingService service) {
        this.service = service;
    }

    @PostMapping("/get-ticketnumber")
    @Operation(operationId = "POST Request" , description = "This is request the passenger and return the passenger ID")
    public ResponseEntity<Integer> registerPassenger(@RequestBody Passenger passenger) {
        Passenger passenger1 = service.registerPassenger(passenger);
        return new ResponseEntity<>(passenger1.getPid(), HttpStatus.CREATED);
    }

    @GetMapping("/get-ticket/{ticketNumber}")
    @Operation(operationId = "GET Request" , description = "This is request the ticketNumber and return the ticket")
    public ResponseEntity<Ticket> getTicket(@PathVariable Integer ticketNumber) {
        Passenger passenger = service.fetchPassengerInfo(ticketNumber);
        Ticket ticket = Ticket.builder()
                .ticketNumber(passenger.getPid())
                .name(passenger.getName())
                .departure(passenger.getDeparture())
                .arrival(passenger.getArrival())
                .dateOfJourney(passenger.getDateOfJourney())
                .ticketPrice(2000.0)
                .status("Confirmed")
                .build();
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}

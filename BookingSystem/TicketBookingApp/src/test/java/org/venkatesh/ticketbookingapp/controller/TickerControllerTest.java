package org.venkatesh.ticketbookingapp.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.venkatesh.ticketbookingapp.model.Passenger;
import org.venkatesh.ticketbookingapp.model.Ticket;
import org.venkatesh.ticketbookingapp.service.TicketBookingService;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class TickerControllerTest {


    @Mock
    private TicketBookingService service;

    @InjectMocks
    private TicketController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    // -------------------------------
    // TEST CASE 1: registerPassenger()
    // -------------------------------
    @Test
    void testRegisterPassenger() {

//        Passenger p = new Passenger(10, "Venkatesh", "Hyd", "Mumbai", LocalDateTime.now());
//
//        when(service.registerPassenger(any(Passenger.class))).thenReturn(p);
//
//        ResponseEntity<Integer> response = controller.registerPassenger(p);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(10, response.getBody());
//        verify(service, times(1)).registerPassenger(p);

        Passenger p  = new Passenger(10 , "venkatesh" , "hyd" , "Mumbai" , LocalDateTime.now());
        when(service.registerPassenger(any(Passenger.class))).thenReturn(p);
        ResponseEntity<Integer> response = controller.registerPassenger(p);

        assertEquals(HttpStatus.CREATED , response.getStatusCode());
        assertEquals(10, response.getBody());
    }



    // -------------------------------
    // TEST CASE 2: getTicket()
    // -------------------------------
    @Test
    void testGetTicket() {

        Passenger passenger = new Passenger(5, "John", "Delhi", "Pune", LocalDateTime.now());

        when(service.fetchPassengerInfo(5)).thenReturn(passenger);

        ResponseEntity<Ticket> response = controller.getTicket(5);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(5, response.getBody().getTicketNumber());
        assertEquals("John", response.getBody().getName());
    }



    // -------------------------------
    // TEST CASE 3: getAllPassengers()
    // -------------------------------
    @Test
    void testGetAllPassengers() {

        List<Passenger> passengers = List.of(
                new Passenger(1, "A", "X", "Y", LocalDateTime.now()),
                new Passenger(2, "B", "P", "Q", LocalDateTime.now())
        );

        when(service.fetchAllPassengers()).thenReturn(passengers);

        ResponseEntity<List<Passenger>> response = controller.getAllPassengers();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        verify(service, times(1)).fetchAllPassengers();
    }
}

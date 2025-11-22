package org.venkatesh.ticketbookingapp.service;

import org.venkatesh.ticketbookingapp.model.Passenger;

import java.util.List;

public interface ITicketBooking {
    Passenger registerPassenger(Passenger passenger);
    Passenger fetchPassengerInfo(Integer id);
    List<Passenger> fetchAllPassengers();
}

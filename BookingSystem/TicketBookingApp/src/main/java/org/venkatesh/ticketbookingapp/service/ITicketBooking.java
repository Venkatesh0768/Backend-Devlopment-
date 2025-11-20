package org.venkatesh.ticketbookingapp.service;

import org.venkatesh.ticketbookingapp.model.Passenger;

public interface ITicketBooking {
    Passenger registerPassenger(Passenger passenger);
    Passenger fetchPassengerInfo(Integer id);
}

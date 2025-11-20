package org.venkatesh.ticketbookingwebapp.service;

import org.venkatesh.ticketbookingwebapp.model.Passenger;
import org.venkatesh.ticketbookingwebapp.model.Ticket;

public interface ITicketService {
    Integer registerPassenger(Passenger passenger);
    Ticket getFullTicket(Integer ticketNumber);
}

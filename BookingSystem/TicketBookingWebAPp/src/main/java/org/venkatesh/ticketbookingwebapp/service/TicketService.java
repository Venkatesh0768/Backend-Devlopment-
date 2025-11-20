package org.venkatesh.ticketbookingwebapp.service;

import org.springframework.stereotype.Service;
import org.venkatesh.ticketbookingwebapp.model.Passenger;
import org.venkatesh.ticketbookingwebapp.model.Ticket;

@Service
public class TicketService implements ITicketService{
    @Override
    public Integer registerPassenger(Passenger passenger) {
        return 0;
    }

    @Override
    public Ticket getFullTicket(Integer ticketNumber) {
        return null;
    }
}

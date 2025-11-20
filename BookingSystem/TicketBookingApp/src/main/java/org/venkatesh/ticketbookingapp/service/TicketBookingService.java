package org.venkatesh.ticketbookingapp.service;

import org.springframework.stereotype.Service;
import org.venkatesh.ticketbookingapp.model.Passenger;
import org.venkatesh.ticketbookingapp.repository.PassengerRepository;

import java.util.Optional;

@Service
public class TicketBookingService implements ITicketBooking {

    private final PassengerRepository repository;

    public TicketBookingService(PassengerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Passenger registerPassenger(Passenger passenger) {
        return repository.save(passenger);
    }

    @Override
    public Passenger fetchPassengerInfo(Integer id) {
        Optional<Passenger> optional = repository.findById(id);
        return optional.get();
    }
}

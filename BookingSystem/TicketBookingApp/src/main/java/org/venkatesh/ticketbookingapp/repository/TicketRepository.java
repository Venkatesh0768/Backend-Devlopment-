package org.venkatesh.ticketbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.venkatesh.ticketbookingapp.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}

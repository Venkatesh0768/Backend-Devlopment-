package org.venkatesh.ticketbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.venkatesh.ticketbookingapp.model.Passenger;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger , Integer> {
}

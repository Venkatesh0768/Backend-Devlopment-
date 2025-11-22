package org.venkatesh.ticketbookingwebapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.venkatesh.ticketbookingwebapp.model.Passenger;
import org.venkatesh.ticketbookingwebapp.model.Ticket;

@Service
public class TicketService implements ITicketService {

    String url = "http://localhost:8080/api/v1/get-ticketnumber";
    String get_url = "http://localhost:8080/api/v1/get-ticket/{ticketNumber}";


    @Override
    public Integer registerPassenger(Passenger passenger) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Integer> response = restTemplate.postForEntity(url, passenger, Integer.class);
//        return response.getBody();
        WebClient webClient = WebClient.create();
        return webClient.post().uri(url).bodyValue(passenger).retrieve().bodyToMono(Integer.class).block();
    }

    @Override
    public Ticket getFullTicket(Integer ticketNumber) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Ticket> response = restTemplate.getForEntity(get_url, Ticket.class, ticketNumber);
//        return response.getBody();
        WebClient webClient = WebClient.create();
        return webClient.get().uri(get_url, ticketNumber).retrieve().bodyToMono(Ticket.class).block();
    }
}

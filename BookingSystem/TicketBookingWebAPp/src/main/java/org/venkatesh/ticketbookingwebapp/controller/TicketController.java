package org.venkatesh.ticketbookingwebapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.venkatesh.ticketbookingwebapp.model.Passenger;
import org.venkatesh.ticketbookingwebapp.model.Ticket;
import org.venkatesh.ticketbookingwebapp.service.TicketService;

@RestController
public class TicketController {
    private final  TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping("/book-ticket")
    public String bookTicket(@ModelAttribute Passenger passenger , Model model){
        Integer ticketNumber = service.registerPassenger(passenger);
        model.addAttribute("ticketNumber" , ticketNumber);
        return "index";
    }

    @GetMapping("/passenger-form")
    public String bookTicketForm(@ModelAttribute Passenger passenger , Model model){
        Integer ticketNumber = service.registerPassenger(passenger);
        model.addAttribute("passenger" , new Passenger());
        return "index";
    }
    @PostMapping("/ticket-form")
    public String ticketForm(@ModelAttribute Passenger passenger , Model model){
        model.addAttribute("passenger" , new Passenger());
        return "ticket-form";
    }

    @GetMapping("/get-ticket")
    public String getTicket(@RequestParam("ticketNumber") Integer ticketNumber, Model model){
        Ticket ticket = service.getFullTicket(ticketNumber);
        model.addAttribute("ticket" , ticket);
        return "ticket-info";
    }
}

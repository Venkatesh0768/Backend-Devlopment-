package org.venkatesh.ticketbookingwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.venkatesh.ticketbookingwebapp.model.Passenger;
import org.venkatesh.ticketbookingwebapp.model.Ticket;
import org.venkatesh.ticketbookingwebapp.service.TicketService;
@Controller
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping("/ticket-form")
    public String ticketForm(Model model) {
        model.addAttribute("passenger", new Passenger());
        return "ticket-form";
    }

    @PostMapping("/book-ticket")
    public String bookTicket(@ModelAttribute Passenger passenger, Model model) {
        Integer ticketNumber = service.registerPassenger(passenger);
        model.addAttribute("ticketNumber", ticketNumber);
        return "index";
    }

    @GetMapping("/get-ticket")
    public String getTicket(@RequestParam(required = false) Integer ticketNumber, Model model) {
        if(ticketNumber != null){
            Ticket ticket = service.getFullTicket(ticketNumber);
            model.addAttribute("ticket", ticket);
        }
        return "ticket-info";
    }
}

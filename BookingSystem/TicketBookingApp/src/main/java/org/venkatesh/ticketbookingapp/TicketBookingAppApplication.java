package org.venkatesh.ticketbookingapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "This Ticket Booking API",
                version = "v1.0",
                description = "This api will Book and genearte ticket"
        ),
        servers = @Server(
                url = "http://localhost:8080/",
                description = "This api Depoly for the Following Application"
        )
)
public class TicketBookingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketBookingAppApplication.class, args);
    }

}

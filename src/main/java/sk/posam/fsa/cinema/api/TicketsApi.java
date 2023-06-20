package sk.posam.fsa.cinema.api;

import org.springframework.web.bind.annotation.*;
import sk.posam.fsa.cinema.domain.Ticket;

import java.util.Collection;

@RequestMapping("/v1")
public interface TicketsApi {

    @GetMapping("/tickets/screening/{id}")
    Collection<TicketDto> allByScreeningId(@PathVariable Long id);


    @PutMapping("/tickets/{id}")
    void updateTicket(@RequestBody TicketDto newTicket, @PathVariable Long id);

    @PutMapping("/tickets/{id}/res")
    void updateTicketWithRes(@RequestBody TicketDto newTicket, @PathVariable Long id);
}
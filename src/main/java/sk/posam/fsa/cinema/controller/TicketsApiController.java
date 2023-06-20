package sk.posam.fsa.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.cinema.api.TicketDto;
import sk.posam.fsa.cinema.api.TicketsApi;
import sk.posam.fsa.cinema.application.TicketsApiService;

import java.util.Collection;

@RestController
public class TicketsApiController implements TicketsApi {

    @Autowired
    private TicketsApiService apiService;
    @Override
    public Collection<TicketDto> allByScreeningId(Long id) {
        return apiService.findTicketsByScreeningId(id);
    }

    @Override
    public void updateTicket(TicketDto newTicket, Long id) {
        apiService.replaceTicket(newTicket, id);
    }

    @Override
    public void updateTicketWithRes(TicketDto newTicket, Long id) {
        apiService.replaceTicketWithRes(newTicket, id);
    }
}

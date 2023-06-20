package sk.posam.fsa.cinema.application;

import sk.posam.fsa.cinema.api.TicketDto;

import java.util.Collection;

public interface TicketsApiService {

    Collection<TicketDto> findTicketsByScreeningId(Long screeningId);

    void replaceTicket(TicketDto newTicket, Long id);

    void replaceTicketWithRes(TicketDto newTicket, Long id);
}

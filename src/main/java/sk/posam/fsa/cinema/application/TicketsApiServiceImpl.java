package sk.posam.fsa.cinema.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import sk.posam.fsa.cinema.api.TicketDto;
import sk.posam.fsa.cinema.application.assembler.ReservationAssembler;
import sk.posam.fsa.cinema.application.assembler.TicketAssembler;
import sk.posam.fsa.cinema.application.repository.ScreeningCrudRepository;
import sk.posam.fsa.cinema.application.repository.TicketCrudRepository;
import sk.posam.fsa.cinema.domain.Reservation;
import sk.posam.fsa.cinema.domain.Ticket;


import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class TicketsApiServiceImpl implements TicketsApiService {

    @Autowired
    private TicketCrudRepository ticketCrudRepository;

    private TicketAssembler ticketAssembler = new TicketAssembler();
    @Override
    public Collection<TicketDto> findTicketsByScreeningId(Long screeningId) {
        return ticketAssembler.toDto(ticketCrudRepository.findByScreeningId(screeningId));
    }

    @Override
    @Transactional
    public void replaceTicketWithRes(TicketDto newTicket, Long id) {
        Optional<Ticket> ticketResult = ticketCrudRepository.findById(id);

        Ticket ticket;
        if (ticketResult.isPresent()) {
            ticket = ticketResult.get();
            ticket.setState(newTicket.state);
            ticket.setType(newTicket.type);
            ticket.setReservation(new ReservationAssembler().fromDto(newTicket.reservation));
        } else {
            newTicket.id = id;
            ticket = ticketAssembler.fromDto(newTicket);
        }
        try {
            ticketCrudRepository.save(ticket);
        } catch(OptimisticLockingFailureException ex) {

        }
    }

    @Override
    @Transactional
    public void replaceTicket(TicketDto newTicket, Long id) {
        Optional<Ticket> ticketResult = ticketCrudRepository.findById(id);

        Ticket ticket;
        if (ticketResult.isPresent()) {
            if (ticketResult.get().getState() == 1 && newTicket.state == 1) {
                throw new IllegalStateException("The state attribute is already set to 1 and cannot be modified.");
            }
            ticket = ticketResult.get();
            ticket.setState(newTicket.state);
            ticket.setType(newTicket.type);
            ticket.setReservation(new ReservationAssembler().fromDto(newTicket.reservation));
        } else {
            newTicket.id = id;
            ticket = ticketAssembler.fromDto(newTicket);
        }
        try {
            ticketCrudRepository.save(ticket);
        } catch(OptimisticLockingFailureException ex) {

        }
    }
}

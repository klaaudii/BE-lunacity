package sk.posam.fsa.cinema.application.assembler;

import sk.posam.fsa.cinema.api.TicketDto;
import sk.posam.fsa.cinema.domain.Ticket;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketAssembler {

    public Collection<TicketDto> toDto(Collection<Ticket> tickets) {
        return tickets.stream()
                .map(this::toDto)
                .collect(Collectors.toSet());
    }

    public TicketDto toDto(Ticket ticket) {
        TicketDto result = new TicketDto();
        result.id = ticket.getId();
        result.seat = new SeatAssembler().toDto(ticket.getSeat());
        result.type = ticket.getType();
        result.state = ticket.getState();
        result.version = ticket.getVersion();
        result.reservation = new ReservationAssembler().toDto(ticket.getReservation());
        return result;
    }

    public Set<Ticket> fromDto(Collection<TicketDto> tickets) {
        return tickets.stream()
                .map(this::fromDto)
                .collect(Collectors.toSet());
    }

    public Ticket fromDto(TicketDto dto) {
        Ticket result = new Ticket();

        result.setId(dto.id);
//        result.setSeat(new SeatAssembler().dto.seat);
        result.setType(dto.type);
        result.setState(dto.state);
        result.setVersion(dto.version);
        result.setReservation(new ReservationAssembler().fromDto(dto.reservation));
        return result;
    }


}
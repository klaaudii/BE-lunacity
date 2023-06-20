package sk.posam.fsa.cinema.application.assembler;

import sk.posam.fsa.cinema.api.ReservationDto;
import sk.posam.fsa.cinema.api.TicketDto;
import sk.posam.fsa.cinema.domain.Reservation;
import sk.posam.fsa.cinema.domain.Ticket;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ReservationAssembler {
    public Collection<ReservationDto> toDto(Iterable<Reservation> reservations) {
        return StreamSupport.stream(reservations.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ReservationDto toDto(Reservation reservation) {
        ReservationDto result = new ReservationDto();
        result.id = reservation.getId();
        result.firstName = reservation.getFirstName();
        result.lastName = reservation.getLastName();
        result.email = reservation.getEmail();
        result.phoneNumber = reservation.getPhoneNumber();
        result.created = reservation.getCreated();
//        result.tickets = new TicketAssembler().toDto(reservation.getTickets());
        return result;
    }

    public Reservation fromDto(ReservationDto dto) {
        Reservation result = new Reservation();
        result.setId(dto.id);
        result.setCreated(dto.created);
        result.setFirstName(dto.firstName);
        result.setLastName(dto.lastName);
        result.setEmail(dto.email);
        result.setPhoneNumber(dto.phoneNumber);
//        result.setTickets(new TicketAssembler().fromDto(dto.tickets));
        return result;
    }
}

package sk.posam.fsa.cinema.application;

import sk.posam.fsa.cinema.api.ReservationDto;
import sk.posam.fsa.cinema.domain.Reservation;

import java.util.Collection;

public interface ReservationsApiService {

    ReservationDto newReservation(ReservationDto dto);

    Collection<ReservationDto> getAllReservations();
}

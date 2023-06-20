package sk.posam.fsa.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.cinema.api.ReservationDto;
import sk.posam.fsa.cinema.api.ReservationsApi;
import sk.posam.fsa.cinema.application.ReservationsApiService;
import sk.posam.fsa.cinema.application.assembler.ReservationAssembler;
import sk.posam.fsa.cinema.domain.Reservation;

import java.util.Collection;


@RestController
public class ReservationsApiController implements ReservationsApi {

    @Autowired
    private ReservationsApiService reservationsApiService;

    private ReservationAssembler reservationAssembler = new ReservationAssembler();


    @Override
    public ReservationDto newReservation(ReservationDto newReservation) {
        System.out.println(newReservation);
        return reservationsApiService.newReservation(newReservation);
    }

    @Override
    public Collection<ReservationDto> getAllReservations() {
        return reservationsApiService.getAllReservations();
    }
}

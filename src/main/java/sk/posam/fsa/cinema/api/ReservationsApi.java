package sk.posam.fsa.cinema.api;


import org.springframework.web.bind.annotation.*;
import sk.posam.fsa.cinema.domain.Reservation;

import java.util.Collection;

@RequestMapping("/v1")
public interface ReservationsApi {

    @PostMapping("/reservations")
    ReservationDto newReservation(@RequestBody ReservationDto newReservation);

//    @GetMapping("/reservations")
//    long newReservation(@RequestBody ReservationDto newReservation);

    @GetMapping("/reservations")
    Collection<ReservationDto> getAllReservations();

}

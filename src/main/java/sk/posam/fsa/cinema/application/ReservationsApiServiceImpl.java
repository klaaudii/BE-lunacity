package sk.posam.fsa.cinema.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.posam.fsa.cinema.api.ReservationDto;
import sk.posam.fsa.cinema.application.assembler.ReservationAssembler;
import sk.posam.fsa.cinema.application.repository.ReservationCrudRepository;
import sk.posam.fsa.cinema.domain.Reservation;

import java.util.Collection;

@Service
public class ReservationsApiServiceImpl implements ReservationsApiService{
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    private ReservationAssembler reservationAssembler = new ReservationAssembler();


    @Override
    public ReservationDto newReservation(ReservationDto dto) {
        System.out.println(dto);
        Reservation newReservation = reservationCrudRepository.save(reservationAssembler.fromDto(dto));
        return reservationAssembler.toDto(newReservation);
    }

    @Override
    public Collection<ReservationDto> getAllReservations() {
        return reservationAssembler.toDto(reservationCrudRepository.findAll());
    }
}

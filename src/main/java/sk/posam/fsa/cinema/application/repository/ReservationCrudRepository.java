package sk.posam.fsa.cinema.application.repository;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.cinema.domain.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Long> {

}

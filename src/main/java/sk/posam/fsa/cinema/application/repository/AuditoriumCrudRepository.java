package sk.posam.fsa.cinema.application.repository;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.cinema.domain.Auditorium;


public interface AuditoriumCrudRepository extends CrudRepository<Auditorium, Long> {
}

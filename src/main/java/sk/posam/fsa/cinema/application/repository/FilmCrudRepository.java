package sk.posam.fsa.cinema.application.repository;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.cinema.domain.Film;

public interface FilmCrudRepository extends CrudRepository<Film, Long> {
}

package sk.posam.fsa.cinema.application.repository;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.cinema.domain.Genre;

public interface GenreCrudRepository extends CrudRepository<Genre, Long> {
}

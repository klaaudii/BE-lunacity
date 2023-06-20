package sk.posam.fsa.cinema.domain.repositories;

import sk.posam.fsa.cinema.domain.Film;

public interface FilmRepository {
    Film read(long id);
}
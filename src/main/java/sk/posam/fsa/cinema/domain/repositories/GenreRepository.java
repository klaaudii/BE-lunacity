package sk.posam.fsa.cinema.domain.repositories;

import sk.posam.fsa.cinema.domain.Genre;

public interface GenreRepository {
    Genre read(long id);
}

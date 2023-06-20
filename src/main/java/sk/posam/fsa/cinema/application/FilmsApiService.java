package sk.posam.fsa.cinema.application;

import sk.posam.fsa.cinema.api.FilmDto;

import java.util.Collection;

public interface FilmsApiService {
    FilmDto getFilmById(Long id);

    Collection<FilmDto> getAllFilms();

}

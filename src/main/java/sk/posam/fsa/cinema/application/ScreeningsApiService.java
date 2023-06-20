package sk.posam.fsa.cinema.application;

import sk.posam.fsa.cinema.api.ScreeningDto;
import sk.posam.fsa.cinema.api.ScreeningGroupDto;

import java.time.LocalDate;
import java.util.Collection;

public interface ScreeningsApiService {

//    Collection<ScreeningDto> findScreeningsByDate(LocalDate date);

    Collection<ScreeningGroupDto> findScreeningsByDateAndGenreGroupedByFilm(LocalDate date, Long genreId);

    Collection<ScreeningDto> findScreeningsByFilmAndDate(Long filmId, LocalDate date);

    Collection<Collection<ScreeningDto>> findAllScreeningsInNextWeekByFilm(Long filmId);
}

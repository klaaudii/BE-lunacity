package sk.posam.fsa.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.cinema.api.ScreeningDto;
import sk.posam.fsa.cinema.api.ScreeningGroupDto;
import sk.posam.fsa.cinema.api.ScreeningsApi;
import sk.posam.fsa.cinema.application.ScreeningsApiService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;


@RestController
public class ScreeningsApiController implements ScreeningsApi {

    @Autowired
    private ScreeningsApiService apiService;

    @Override
    public Collection<ScreeningGroupDto> allByDateAndGenreGroupedByFilm(String dateFilter, Long genreFilter) {
        return apiService.findScreeningsByDateAndGenreGroupedByFilm(
                LocalDate.parse(dateFilter ),  genreFilter);
    }

    @Override
    public Collection<ScreeningDto> allByFilmAndDate(Long id, String dateFilter) {
        return apiService.findScreeningsByFilmAndDate(id, LocalDate.parse(dateFilter));
    }

    @Override
    public Collection<Collection<ScreeningDto>> allInNextWeekByFilm(Long id) {
        return apiService.findAllScreeningsInNextWeekByFilm(id);
    }
}

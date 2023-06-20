package sk.posam.fsa.cinema.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.posam.fsa.cinema.api.ScreeningDto;
import sk.posam.fsa.cinema.api.ScreeningGroupDto;
import sk.posam.fsa.cinema.application.assembler.FilmAssembler;
import sk.posam.fsa.cinema.application.assembler.ScreeningAssembler;
import sk.posam.fsa.cinema.application.repository.ScreeningCrudRepository;
import sk.posam.fsa.cinema.domain.Film;
import sk.posam.fsa.cinema.domain.FilmDetailService;
import sk.posam.fsa.cinema.domain.Genre;
import sk.posam.fsa.cinema.domain.Screening;
import sk.posam.fsa.cinema.domain.repositories.ScreeningRepository;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ScreeningsApiServiceImpl implements ScreeningsApiService {

    @Autowired
    private ScreeningCrudRepository screeningRepository;

    @Autowired
    private FilmDetailService filmDetailService;

    private ScreeningAssembler screeningAssembler = new ScreeningAssembler();

    private FilmAssembler filmAssembler = new FilmAssembler();

    @Override
    public Collection<ScreeningGroupDto> findScreeningsByDateAndGenreGroupedByFilm(LocalDate date, Long genreId) {
        Collection<Screening> screenings = screeningRepository.findByDate(date);

        if (genreId != null) {
            screenings = screenings.stream().filter(screening ->
                    filmDetailService.isFilmOfGenre(screening.getFilm().getId(), genreId)).toList();
        }

        Map<Film, List<Screening>> screeningsByFilm = screenings.stream()
                .collect(Collectors.groupingBy(Screening::getFilm));

        Collection<ScreeningGroupDto> screeningGroups = new ArrayList<>();
        screeningsByFilm.forEach((film, s) -> {
            ScreeningGroupDto groupDto = new ScreeningGroupDto();
            groupDto.film = filmAssembler.toDto(film);
            groupDto.screenings = screeningAssembler.toDto(s);
            screeningGroups.add(groupDto);
        });

        return screeningGroups;
    }

    @Override
    public List<ScreeningDto> findScreeningsByFilmAndDate(Long filmId, LocalDate date) {
        return screeningAssembler.toDto(screeningRepository.findByFilmIdAndDateOrderByTime(filmId, date));
    }

    @Override
    public Collection<Collection<ScreeningDto>> findAllScreeningsInNextWeekByFilm(Long filmId) {
        var date = LocalDate.now();
        var screeningsWeek = new ArrayList<Collection<ScreeningDto>>();
        for (int i = 0; i < 7; i++){
            screeningsWeek.add(findScreeningsByFilmAndDate(filmId, date.plusDays(i)));
        }
        return screeningsWeek;
    }
}

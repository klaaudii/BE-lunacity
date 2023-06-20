package sk.posam.fsa.cinema.api;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/v1")
public interface ScreeningsApi {

    @GetMapping("/screenings")
    Collection<ScreeningGroupDto> allByDateAndGenreGroupedByFilm(@RequestParam (name = "date") String dateFilter,
                                                         @RequestParam (name = "genre", required = false) Long genreFilter);

    @GetMapping("/screenings/{id}")
    Collection<ScreeningDto> allByFilmAndDate(@PathVariable Long id,
                                              @RequestParam (name = "date") String dateFilter);

    @GetMapping("/screenings/week/{id}")
    Collection<Collection<ScreeningDto>> allInNextWeekByFilm(@PathVariable Long id);


}
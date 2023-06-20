package sk.posam.fsa.cinema.application.assembler;

import sk.posam.fsa.cinema.api.FilmDto;
import sk.posam.fsa.cinema.domain.Film;

import java.util.Set;
import java.util.stream.Collectors;

public class FilmAssembler {

    public Set<FilmDto> toDto(Set<Film> films) {
        return films.stream()
                .map(this::toDto)
                .collect(Collectors.toSet());
    }

    public FilmDto toDto(Film film) {
        FilmDto result = new FilmDto();

        result.id = film.getId();
        result.title = film.getTitle();
        result.description = film.getDescription();
        result.releaseYear = film.getReleaseYear();
        result.length = film.getLength();
//        result.language = new LanguageAssembler().toDto(film.getLanguage());
        result.rating = new RatingAssembler().toDto(film.getRating());
        result.subtitles = new SubtitlesAssembler().toDto(film.getSubtitles());
        result.genres = new GenreAssembler().toDtoNoFilms(film.getGenres());
        result.imagePath = "http://localhost:8080/v1/films/" + result.id + "/image";
        result.bgImagePath = "http://localhost:8080/v1/films/" + result.id + "/bg-image";
        result.youtubePath = film.getYoutubePath();
        return result;
    }
}

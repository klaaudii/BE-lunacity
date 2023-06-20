package sk.posam.fsa.cinema.application.assembler;

import sk.posam.fsa.cinema.api.GenreDto;
import sk.posam.fsa.cinema.api.GenreDtoNoFilms;
import sk.posam.fsa.cinema.domain.Genre;

import java.util.Set;
import java.util.stream.Collectors;

public class GenreAssembler {

    public Set<GenreDto> toDto(Set<Genre> genres) {
        return genres.stream()
                .map(this::toDto)
                .collect(Collectors.toSet());
    }

    public GenreDto toDto(Genre genre) {
        GenreDto result = new GenreDto();
        result.id = genre.getId();
        result.name = genre.getName();
        result.films = new FilmAssembler().toDto(genre.getFilms());
        return result;
    }

    public Set<GenreDtoNoFilms> toDtoNoFilms(Set<Genre> genres) {
        return genres.stream()
                .map(this::toDtoNoFilms)
                .collect(Collectors.toSet());
    }

    public GenreDtoNoFilms toDtoNoFilms(Genre genre) {
        GenreDtoNoFilms result = new GenreDtoNoFilms();
        result.id = genre.getId();
        result.name = genre.getName();
        return result;
    }
}

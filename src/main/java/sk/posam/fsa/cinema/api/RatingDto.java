package sk.posam.fsa.cinema.api;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

public class RatingDto {
    public Long id;

    public String name;

    public String explanation;

    @JsonIgnore
    public Set<FilmDto> films;
}

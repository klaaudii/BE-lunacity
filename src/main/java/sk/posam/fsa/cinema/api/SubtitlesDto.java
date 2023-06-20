package sk.posam.fsa.cinema.api;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

public class SubtitlesDto {
    public Long id;

    public String name;

    @JsonIgnore
    public Set<FilmDto> films;
}

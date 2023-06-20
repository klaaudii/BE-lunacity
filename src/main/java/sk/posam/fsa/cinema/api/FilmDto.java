package sk.posam.fsa.cinema.api;

import java.util.Set;

public class FilmDto {

    public Long id;

    public String title;

    public String description;

    public Integer releaseYear;

    public Integer length;

    public LanguageDto language;

    public SubtitlesDto subtitles;

    public RatingDto rating;

    public Set<GenreDtoNoFilms> genres;

    public String imagePath;

    public String bgImagePath;

    public String youtubePath;

}
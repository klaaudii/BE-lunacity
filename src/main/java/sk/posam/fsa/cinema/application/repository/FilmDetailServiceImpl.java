package sk.posam.fsa.cinema.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.posam.fsa.cinema.domain.Genre;
import sk.posam.fsa.cinema.domain.Film;
import sk.posam.fsa.cinema.domain.FilmDetailService;
import sk.posam.fsa.cinema.domain.repositories.GenreRepository;
import sk.posam.fsa.cinema.domain.repositories.FilmRepository;

@Service
public class FilmDetailServiceImpl implements FilmDetailService {


    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public boolean isFilmOfGenre(long filmId, long genreId) {
        Film film = filmRepository.read(filmId);
        Genre genre = genreRepository.read(genreId);
        return film.getGenres().contains(genre);
    }
}

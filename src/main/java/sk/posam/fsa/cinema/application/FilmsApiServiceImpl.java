package sk.posam.fsa.cinema.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.posam.fsa.cinema.api.FilmDto;
import sk.posam.fsa.cinema.application.assembler.FilmAssembler;
import sk.posam.fsa.cinema.application.repository.FilmCrudRepository;
import sk.posam.fsa.cinema.domain.Film;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmsApiServiceImpl implements FilmsApiService {

    @Autowired
    private FilmCrudRepository filmCrudRepository;

    private FilmAssembler filmAssembler = new FilmAssembler();

    @Override
    public FilmDto getFilmById(Long id) {
        Optional<Film> film = filmCrudRepository.findById(id);
        return film.map(filmAssembler::toDto).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public Collection<FilmDto> getAllFilms() {
        Iterable<Film> film = filmCrudRepository.findAll();

        Collection<Film> result = new ArrayList();
        film.forEach(result::add);
        return result.stream().map(filmAssembler::toDto).toList();
    }
}

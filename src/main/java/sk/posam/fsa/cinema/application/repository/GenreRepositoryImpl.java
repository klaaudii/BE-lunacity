package sk.posam.fsa.cinema.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.posam.fsa.cinema.domain.Genre;
import sk.posam.fsa.cinema.domain.repositories.GenreRepository;

import java.util.Optional;

@Repository
public class GenreRepositoryImpl implements GenreRepository {

    @Autowired
    private GenreCrudRepository genreCrudRepository;

    @Override
    public Genre read(long id) {
        Optional<Genre> genre = genreCrudRepository.findById(id);
        return genre.get();
    }
}

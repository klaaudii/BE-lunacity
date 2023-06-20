package sk.posam.fsa.cinema.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.posam.fsa.cinema.api.AuditoriumDto;
import sk.posam.fsa.cinema.api.FilmDto;
import sk.posam.fsa.cinema.application.assembler.AuditoriumAssembler;
import sk.posam.fsa.cinema.application.repository.AuditoriumCrudRepository;
import sk.posam.fsa.cinema.domain.Auditorium;
import sk.posam.fsa.cinema.domain.Film;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AuditoriumsApiServiceImpl implements AuditoriumsApiService{

    @Autowired
    private AuditoriumCrudRepository auditoriumCrudRepository;

    private AuditoriumAssembler auditoriumAssembler = new AuditoriumAssembler();

    @Override
    public AuditoriumDto getAuditoriumById(Long id) {
        Optional<Auditorium> auditorium = auditoriumCrudRepository.findById(id);
        return auditorium.map(auditoriumAssembler::toDto).orElseThrow(() -> new EntityNotFoundException());
    }

}

package sk.posam.fsa.cinema.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.posam.fsa.cinema.domain.Screening;
import sk.posam.fsa.cinema.domain.repositories.ScreeningRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ScreeningRepositoryImpl implements ScreeningRepository {

    @Autowired
    private ScreeningCrudRepository screeningCrudRepository;

    @Override
    public List<Screening> findByDate(LocalDate date) {
        return screeningCrudRepository.findByDate(date);
    }
}

package sk.posam.fsa.cinema.domain.repositories;

import sk.posam.fsa.cinema.domain.Screening;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ScreeningRepository {

    List<Screening> findByDate(LocalDate date);
}

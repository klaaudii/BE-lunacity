package sk.posam.fsa.cinema.application.repository;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.cinema.domain.Screening;

import java.time.LocalDate;
import java.util.List;

public interface ScreeningCrudRepository extends CrudRepository<Screening, Long> {

    List<Screening> findByDate(LocalDate date);
//    @Query("SELECT s FROM Screening s JOIN s.film f JOIN f.genres c WHERE s.date = :date AND c.name = :genre")
//    List<Screening> findByDateAndGenre(LocalDate date, String genre);

    List<Screening> findByFilmIdAndDateOrderByTime(Long id, LocalDate date);
}

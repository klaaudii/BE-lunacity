package sk.posam.fsa.cinema.application.repository;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.cinema.domain.Language;

public interface LanguageCrudRepository extends CrudRepository<Language, Long> {

}

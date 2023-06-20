package sk.posam.fsa.cinema.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.posam.fsa.cinema.domain.Language;
import sk.posam.fsa.cinema.domain.repositories.LanguageRepository;

import java.util.Optional;

@Repository
public class LanguageRepositoryImpl implements LanguageRepository {

    @Autowired
    private LanguageCrudRepository languageCrudRepository;

    @Override
    public Language read(long id) {
        Optional<Language> language = languageCrudRepository.findById(id);
        return language.get();
    }
}

package sk.posam.fsa.cinema.domain.repositories;

import sk.posam.fsa.cinema.domain.Language;

public interface LanguageRepository {
    Language read(long id);
}

package sk.posam.fsa.cinema.application.assembler;

import sk.posam.fsa.cinema.api.FilmDto;
import sk.posam.fsa.cinema.api.LanguageDto;
import sk.posam.fsa.cinema.domain.Film;
import sk.posam.fsa.cinema.domain.Language;

import java.util.Set;
import java.util.stream.Collectors;

public class LanguageAssembler {

    public Set<LanguageDto> toDto(Set<Language> languages) {
        return languages.stream()
                .map(this::toDto)
                .collect(Collectors.toSet());
    }

    public LanguageDto toDto(Language language) {
        LanguageDto result = new LanguageDto();
        result.id = language.getId();
        result.name = language.getName();
        return result;
    }
}

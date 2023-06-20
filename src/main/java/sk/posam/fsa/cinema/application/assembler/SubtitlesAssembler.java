package sk.posam.fsa.cinema.application.assembler;

import sk.posam.fsa.cinema.api.LanguageDto;
import sk.posam.fsa.cinema.api.SubtitlesDto;
import sk.posam.fsa.cinema.domain.Language;
import sk.posam.fsa.cinema.domain.Subtitles;

import java.util.Set;
import java.util.stream.Collectors;

public class SubtitlesAssembler {

    public Set<SubtitlesDto> toDto(Set<Subtitles> subtitlesSet) {
        return subtitlesSet.stream()
                .map(this::toDto)
                .collect(Collectors.toSet());
    }

    public SubtitlesDto toDto(Subtitles subtitles) {
        SubtitlesDto result = new SubtitlesDto();
        result.id = subtitles.getId();
        result.name = subtitles.getName();
        return result;
    }
}

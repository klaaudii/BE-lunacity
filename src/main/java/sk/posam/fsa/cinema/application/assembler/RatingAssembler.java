package sk.posam.fsa.cinema.application.assembler;

import sk.posam.fsa.cinema.api.RatingDto;
import sk.posam.fsa.cinema.api.SubtitlesDto;
import sk.posam.fsa.cinema.domain.Rating;
import sk.posam.fsa.cinema.domain.Subtitles;

import java.util.Set;
import java.util.stream.Collectors;

public class RatingAssembler {

    public Set<RatingDto> toDto(Set<Rating> ratings) {
        return ratings.stream()
                .map(this::toDto)
                .collect(Collectors.toSet());
    }

    public RatingDto toDto(Rating rating) {
        RatingDto result = new RatingDto();
        result.id = rating.getId();
        result.name = rating.getName();
        result.explanation = rating.getExplanation();
        return result;
    }
}

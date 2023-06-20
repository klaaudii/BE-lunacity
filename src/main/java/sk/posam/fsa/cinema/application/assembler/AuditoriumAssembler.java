package sk.posam.fsa.cinema.application.assembler;

import sk.posam.fsa.cinema.api.AuditoriumDto;
import sk.posam.fsa.cinema.api.LanguageDto;
import sk.posam.fsa.cinema.domain.Auditorium;
import sk.posam.fsa.cinema.domain.Language;

import java.util.Set;
import java.util.stream.Collectors;

public class AuditoriumAssembler {
    public Set<AuditoriumDto> toDto(Set<Auditorium> auditoriums) {
        return auditoriums.stream()
                .map(this::toDto)
                .collect(Collectors.toSet());
    }

    public AuditoriumDto toDto(Auditorium auditorium) {
        AuditoriumDto result = new AuditoriumDto();
        result.id = auditorium.getId();
        result.name = auditorium.getName();
        result.seats =new SeatAssembler().toDto(auditorium.getSeats());
        return result;
    }
}

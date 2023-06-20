package sk.posam.fsa.cinema.application.assembler;

import sk.posam.fsa.cinema.api.SeatDto;
import sk.posam.fsa.cinema.api.SubtitlesDto;
import sk.posam.fsa.cinema.domain.Seat;
import sk.posam.fsa.cinema.domain.Subtitles;

import java.util.Set;
import java.util.stream.Collectors;

public class SeatAssembler {

    public Set<SeatDto> toDto(Set<Seat> seats) {
        return seats.stream()
                .map(this::toDto)
                .collect(Collectors.toSet());
    }

    public SeatDto toDto(Seat seat) {
        SeatDto result = new SeatDto();
        result.id = seat.getId();
        result.x = seat.getX();
        result.y = seat.getY();
        return result;
    }
}
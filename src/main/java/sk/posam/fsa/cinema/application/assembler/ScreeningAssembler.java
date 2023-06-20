package sk.posam.fsa.cinema.application.assembler;

import sk.posam.fsa.cinema.api.ScreeningDto;
import sk.posam.fsa.cinema.domain.Screening;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ScreeningAssembler {

    public List<ScreeningDto> toDto(Iterable<Screening> screenings) {
        return StreamSupport.stream(screenings.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ScreeningDto toDto(Screening screening) {
        ScreeningDto result = new ScreeningDto();

        result.id = screening.getId();
        result.date = screening.getDate();
        result.time = screening.getTime();
        result.price = screening.getPrice();
        result.auditorium = new AuditoriumAssembler().toDto(screening.getAuditorium());
        result.film = new FilmAssembler().toDto(screening.getFilm());
        result.tickets = new TicketAssembler().toDto( screening.getTickets());
        return result;
    }


}

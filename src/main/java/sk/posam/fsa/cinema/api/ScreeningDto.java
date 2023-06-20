package sk.posam.fsa.cinema.api;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

public class ScreeningDto {
    public Long id;
    public LocalDate date;
    public LocalTime time;
    public Long price;
    @JsonIgnore
    public FilmDto film;
    public AuditoriumDto auditorium;

    public Collection<TicketDto> tickets;


}

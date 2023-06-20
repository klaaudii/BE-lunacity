package sk.posam.fsa.cinema.api;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

public class AuditoriumDto {
    public Long id;

    public String name;
    @JsonIgnore
    public Set<ScreeningDto> screenings;

    public Set<SeatDto> seats;
}

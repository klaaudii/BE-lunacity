package sk.posam.fsa.cinema.api;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

public class SeatDto {

    public Long id;

    public Long x;

    public Long y;

    @JsonIgnore
    public AuditoriumDto auditoriumDto;
}

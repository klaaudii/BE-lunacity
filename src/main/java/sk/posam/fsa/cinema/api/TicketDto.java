package sk.posam.fsa.cinema.api;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import sk.posam.fsa.cinema.domain.Reservation;
import sk.posam.fsa.cinema.domain.Screening;

public class TicketDto {

    public Long id;
    public SeatDto seat;

    public Long state;

    public Long type;

    public Long version;

    public ReservationDto reservation;

    @JsonIgnore
    public ScreeningDto screening;

    @Override
    public String toString() {
        return "TicketDto{" +
                "id=" + id +
                ", seat=" + seat +
                ", state=" + state +
                ", type=" + type +
                ", version=" + version +
                '}';
    }
}
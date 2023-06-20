package sk.posam.fsa.cinema.api;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

public class ReservationDto {
    public Long id;

    public Timestamp created;

    public String firstName;

    public String lastName;

    public String email;

    public String phoneNumber;
 @JsonIgnore
    public Collection<TicketDto> tickets;

    @Override
    public String toString() {
        return "ReservationDto{" +
                "id=" + id +
                ", created=" + created +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}

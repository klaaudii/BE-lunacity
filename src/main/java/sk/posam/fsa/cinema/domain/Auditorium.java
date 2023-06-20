package sk.posam.fsa.cinema.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "auditorium", schema = "public")
@Access(AccessType.FIELD)
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditorium_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "auditorium")
    private Set<Screening> screenings;

    @ManyToMany
    @JoinTable(
            name = "auditorium_seat",
            joinColumns = @JoinColumn(name = "auditorium_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id"))
    private Set<Seat> seats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(Set<Screening> screenings) {
        this.screenings = screenings;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }
}
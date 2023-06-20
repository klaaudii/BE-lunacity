package sk.posam.fsa.cinema.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "seat", schema = "public")
@Access(AccessType.FIELD)
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long id;
    @Column(name = "x")
    private Long x;

    @Column(name = "y")
    private Long y;

    @ManyToMany(mappedBy = "seats")
    private Set<Auditorium> auditoriums;

    @OneToMany(mappedBy = "seat")
    private Set<Ticket> tickets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }

    public Set<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(Set<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

}

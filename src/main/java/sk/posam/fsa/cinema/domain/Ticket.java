package sk.posam.fsa.cinema.domain;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;

@Entity
@Table(name = "ticket", schema = "public")
@Access(AccessType.FIELD)
@DynamicUpdate
@OptimisticLocking(type = OptimisticLockType.ALL)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long id;

    @Column(name = "type")
    private Long type;

    @Column(name = "state")
    private Long state;

    @Version
    @Column(name = "version")
    private Long version;

    @ManyToOne
    @JoinColumn(name="screening_id", nullable = false)
    private Screening screening;

    @ManyToOne
    @JoinColumn(name="seat_id", nullable = false)
    private Seat seat;

    @ManyToOne
    @JoinColumn(name="reservation_id")
    private Reservation reservation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Screening getScreening() {
        return screening;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", type=" + type +
                ", state=" + state +
                ", reservation=" + reservation +
                ", version=" + version +
                ", screening=" + screening +
                ", seat=" + seat +
                '}';
    }
}
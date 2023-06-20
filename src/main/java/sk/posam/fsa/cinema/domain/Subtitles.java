package sk.posam.fsa.cinema.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subtitles", schema = "public")
@Access(AccessType.FIELD)
public class Subtitles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subtitles_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "subtitles")
    private Set<Film> films;

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

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
package sk.posam.fsa.cinema.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rating", schema = "public")
@Access(AccessType.FIELD)
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "explanation")
    private String explanation;

    @OneToMany(mappedBy = "rating")
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

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }


}
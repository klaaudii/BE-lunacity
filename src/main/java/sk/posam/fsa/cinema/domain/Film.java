package sk.posam.fsa.cinema.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "film", schema = "public")
@Access(AccessType.FIELD)
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "length")
    private Integer length;

    @Column(name = "youtube_path")
    private String youtubePath;

    @ManyToOne
    @JoinColumn(name="language_id", nullable = false)
    private Language language;

    @ManyToOne
    @JoinColumn(name="subtitles_id", nullable = false)
    private Subtitles subtitles;

    @ManyToOne
    @JoinColumn(name="rating_id", nullable = false)
    private Rating rating;



    @ManyToMany
    @JoinTable(
            name = "film_genre",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;

    @OneToMany(mappedBy = "film")
    private Set<Screening> screenings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

//    public Language getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(Language language) {
//        this.language = language;
//    }

    public Subtitles getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(Subtitles subtitles) {
        this.subtitles = subtitles;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getYoutubePath() {
        return youtubePath;
    }

    public void setYoutubePath(String youtubePath) {
        this.youtubePath = youtubePath;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(Set<Screening> screenings) {
        this.screenings = screenings;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id) && Objects.equals(title, film.title) && Objects.equals(description, film.description) && Objects.equals(releaseYear, film.releaseYear) && Objects.equals(length, film.length)  && Objects.equals(subtitles, film.subtitles) && Objects.equals(rating, film.rating) && Objects.equals(genres, film.genres) && Objects.equals(screenings, film.screenings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, releaseYear, length, subtitles, rating, genres, screenings);
    }
}

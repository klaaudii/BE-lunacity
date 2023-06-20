package sk.posam.fsa.cinema;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sk.posam.fsa.cinema.domain.Film;
import sk.posam.fsa.cinema.domain.repositories.FilmRepository;
import sk.posam.fsa.cinema.domain.repositories.LanguageRepository;

import javax.sql.DataSource;

@SpringBootApplication
public class CinemaReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaReservationSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(LanguageRepository languageRepository, FilmRepository  filmRepository, DataSource dataSource) {
		return (args) -> {
			//System.out.println(filmRepository.read(1));
//			Film film = filmRepository.read(1);
//			System.out.println(film.getCategories());
//			System.out.println(filmArchiveService.hralHerecVoFilme(143L, 10L));
		};
	}

}

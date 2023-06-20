package sk.posam.fsa.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.cinema.api.FilmDto;
import sk.posam.fsa.cinema.api.FilmsApi;
import sk.posam.fsa.cinema.application.FilmsApiService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

@RestController
public class FilmsApiController implements FilmsApi {

    @Autowired
    private FilmsApiService apiService;

    @Override
    public FilmDto one(Long id) {
        return apiService.getFilmById(id);
    }

    @Override
    public Collection<FilmDto> all() {
        return apiService.getAllFilms();
    }


    @Override
    public ResponseEntity<ByteArrayResource> oneImage(Long id) throws IOException {
        return getImage("images/" + id + ".jpg");

    }

    @Override
    public ResponseEntity<ByteArrayResource> oneBgImage(Long id) throws IOException {
        return getImage("images/" + id + "-bg.jpg");
    }

    private ResponseEntity<ByteArrayResource> getImage(String url) throws IOException {
        final ByteArrayResource imageStream = new ByteArrayResource(Files.readAllBytes(Paths.get(url)));
        return ResponseEntity.ok()
                .contentLength(imageStream.contentLength())
                .body( imageStream);

    }

}

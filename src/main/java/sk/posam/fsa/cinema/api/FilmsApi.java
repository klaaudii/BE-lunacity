package sk.posam.fsa.cinema.api;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@RequestMapping("/v1")
public interface FilmsApi {
    @GetMapping("films/{id}")
    FilmDto one(@PathVariable Long id);

    @GetMapping("films")
    Collection<FilmDto> all();

    @GetMapping(value = "films/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    ResponseEntity<ByteArrayResource> oneImage(@PathVariable Long id) throws IOException;

    @GetMapping(value = "films/{id}/bg-image", produces = MediaType.IMAGE_JPEG_VALUE)
    ResponseEntity<ByteArrayResource> oneBgImage(@PathVariable Long id) throws IOException;

}

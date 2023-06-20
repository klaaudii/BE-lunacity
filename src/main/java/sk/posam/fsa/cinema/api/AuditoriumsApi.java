package sk.posam.fsa.cinema.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1")
public interface AuditoriumsApi {

    @GetMapping("auditorium/{id}")
    AuditoriumDto one(@PathVariable Long id);
}

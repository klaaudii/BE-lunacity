package sk.posam.fsa.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.cinema.api.AuditoriumDto;
import sk.posam.fsa.cinema.api.AuditoriumsApi;
import sk.posam.fsa.cinema.application.AuditoriumsApiService;

@RestController
public class AuditoriumsApiController implements AuditoriumsApi {

    @Autowired
    private AuditoriumsApiService apiService;
    @Override
    public AuditoriumDto one(Long id) {
        return apiService.getAuditoriumById(id);
    }
}

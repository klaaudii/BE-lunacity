package sk.posam.fsa.cinema.application;

import sk.posam.fsa.cinema.api.AuditoriumDto;


public interface AuditoriumsApiService {

    AuditoriumDto getAuditoriumById(Long id);
}

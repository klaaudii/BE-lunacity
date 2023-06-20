package sk.posam.fsa.cinema.application.repository;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.cinema.domain.Screening;
import sk.posam.fsa.cinema.domain.Ticket;

import java.util.Collection;

public interface TicketCrudRepository extends CrudRepository<Ticket, Long> {
    Collection<Ticket> findByScreeningId(Long id);
}

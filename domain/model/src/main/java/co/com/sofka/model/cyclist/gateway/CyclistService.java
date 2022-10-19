package co.com.sofka.model.cyclist.gateway;

import co.com.sofka.model.cyclist.Cyclist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CyclistService {

    Flux<Cyclist> findCyclistByTeamId(String teamId);

    Flux<Cyclist> findCyclistByCountryId(String countryId);

    Flux<Cyclist> findAllCyclistsByNationality(String nationality);

    Mono<Cyclist> createCyclist(Cyclist cyclist);

    Mono<Void> deleteCyclistById(String cyclistId);

    Flux<Cyclist> getAllCyclists();

    Mono<Cyclist> findCyclistById(String cyclistId);
}

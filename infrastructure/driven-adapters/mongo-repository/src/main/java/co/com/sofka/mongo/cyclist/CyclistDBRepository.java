package co.com.sofka.mongo.cyclist;

import co.com.sofka.mongo.cyclist.data.CyclistDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CyclistDBRepository extends ReactiveMongoRepository<CyclistDto, String> {

    Flux<CyclistDto> findAllByTeamId(String teamId);

    Flux<CyclistDto> findAllByCountryId(String countryId);

    Flux<CyclistDto> findAllByNationality(String nationality);
}

package co.com.sofka.mongo.team;

import co.com.sofka.mongo.team.data.TeamDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface TeamDBRepository extends ReactiveMongoRepository<TeamDto, String> {

    Mono<TeamDto> findByCode(String code);

    Mono<TeamDto> findByCountryId(String countryId);

}

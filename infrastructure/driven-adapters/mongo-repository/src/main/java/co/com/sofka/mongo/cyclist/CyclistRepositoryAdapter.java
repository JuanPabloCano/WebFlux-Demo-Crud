package co.com.sofka.mongo.cyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateway.CyclistService;
import co.com.sofka.mongo.cyclist.mapper.CyclistMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
@Component
public class CyclistRepositoryAdapter implements CyclistService {

    private final CyclistDBRepository cyclistDBRepository;
    private final CyclistMapper cyclistMapper;

    public CyclistRepositoryAdapter(CyclistDBRepository cyclistDBRepository, CyclistMapper cyclistMapper) {
        this.cyclistDBRepository = cyclistDBRepository;
        this.cyclistMapper = cyclistMapper;
    }

    @Override
    public Mono<Cyclist> createCyclist(Cyclist cyclist) {
        return this.cyclistDBRepository.save(this.cyclistMapper.mapDtoToEntity(cyclist))
                .map(this.cyclistMapper::mapToEntity)
                .switchIfEmpty(Mono.empty())
                .onErrorResume(Mono::error);
    }

    @Override
    public Flux<Cyclist> findCyclistByTeamId(String teamId) {
        return this.cyclistDBRepository.findAllByTeamId(teamId)
                .map(this.cyclistMapper::mapToEntity)
                .switchIfEmpty(Flux.empty())
                .onErrorResume(Flux::error);
    }

    @Override
    public Flux<Cyclist> findCyclistByCountryId(String countryId) {
        return this.cyclistDBRepository.findAllByCountryId(countryId)
                .map(this.cyclistMapper::mapToEntity)
                .switchIfEmpty(Flux.empty())
                .onErrorResume(Flux::error);
    }

    @Override
    public Flux<Cyclist> findAllCyclistsByNationality(String nationality) {
        return this.cyclistDBRepository.findAllByNationality(nationality)
                .map(this.cyclistMapper::mapToEntity)
                .switchIfEmpty(Flux.empty())
                .onErrorResume(Flux::error);
    }

    @Override
    public Mono<Void> deleteCyclistById(String cyclistId) {
        return this.cyclistDBRepository.deleteById(cyclistId);
    }

    @Override
    public Flux<Cyclist> getAllCyclists() {
        return this.cyclistDBRepository.findAll()
                .map(this.cyclistMapper::mapToEntity)
                .switchIfEmpty(Flux.empty())
                .onErrorResume(Flux::error);
    }

    @Override
    public Mono<Cyclist> findCyclistById(String cyclistId) {
        return this.cyclistDBRepository.findById(cyclistId)
                .map(this.cyclistMapper::mapToEntity)
                .switchIfEmpty(Mono.empty())
                .onErrorResume(Mono::error);
    }
}

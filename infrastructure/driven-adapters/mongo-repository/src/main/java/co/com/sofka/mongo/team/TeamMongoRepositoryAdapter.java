package co.com.sofka.mongo.team;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateway.TeamService;
import co.com.sofka.mongo.team.mapper.TeamMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@Component
public class TeamMongoRepositoryAdapter implements TeamService {

    private final TeamDBRepository teamDBRepository;
    private final TeamMapper teamMapper;

    public TeamMongoRepositoryAdapter(TeamDBRepository teamDBRepository, TeamMapper teamMapper) {
        this.teamDBRepository = teamDBRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public Mono<Team> createTeam(Team team) {
        return this.teamDBRepository.save(this.teamMapper.mapDtoToEntity(team))
                .map(this.teamMapper::mapToEntity)
                .switchIfEmpty(Mono.empty())
                .onErrorResume(Mono::error);
    }

    @Override
    public Mono<Team> findTeamByCode(String code) {
        return this.teamDBRepository.findByCode(code)
                .map(this.teamMapper::mapToEntity)
                .switchIfEmpty(Mono.empty())
                .onErrorResume(Mono::error);
    }

    @Override
    public Mono<Team> findTeamByCountryId(String countryId) {
        return this.teamDBRepository.findByCountryId(countryId)
                .map(this.teamMapper::mapToEntity)
                .switchIfEmpty(Mono.empty())
                .onErrorResume(Mono::error);
    }

    @Override
    public Mono<Void> deleteTeamById(String teamId) {
        return this.teamDBRepository.deleteById(teamId);
    }

    @Override
    public Flux<Team> getAllTeams() {
        return this.teamDBRepository.findAll()
                .map(this.teamMapper::mapToEntity)
                .switchIfEmpty(Flux.empty())
                .onErrorResume(Flux::error);
    }
}

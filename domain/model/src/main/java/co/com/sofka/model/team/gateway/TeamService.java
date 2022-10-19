package co.com.sofka.model.team.gateway;

import co.com.sofka.model.team.Team;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TeamService {

    Mono<Team> findTeamByCode(String code);

    Mono<Team> findTeamByCountryId(String countryId);

    Mono<Team> createTeam(Team team);

    Mono<Void> deleteTeamById(String teamId);

    Flux<Team> getAllTeams();
}

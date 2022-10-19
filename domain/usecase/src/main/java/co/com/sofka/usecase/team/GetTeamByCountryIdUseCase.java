package co.com.sofka.usecase.team;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateway.TeamService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetTeamByCountryIdUseCase {

    private final TeamService teamService;

    public Mono<Team> executeGetTeamByCountryId(String countryId) {
        return this.teamService.findTeamByCountryId(countryId);
    }
}

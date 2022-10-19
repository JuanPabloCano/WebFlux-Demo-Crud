package co.com.sofka.usecase.team;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateway.TeamService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetTeamByCodeUseCase {

    private final TeamService teamService;

    public Mono<Team> executeGetTeamByCode(String code) {
        return this.teamService.findTeamByCode(code);
    }
}

package co.com.sofka.usecase.team;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateway.TeamService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateTeamUseCase {

    private final TeamService teamService;

    public Mono<Team> executeTeamCreation(Team team) {
        return this.teamService.createTeam(team);
    }
}

package co.com.sofka.usecase.team;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateway.TeamService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GetAllTeamsUseCase {

    private final TeamService teamService;

    public Flux<Team> executeGetAllTeams() {
        return this.teamService.getAllTeams();
    }
}

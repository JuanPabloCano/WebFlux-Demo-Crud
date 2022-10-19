package co.com.sofka.usecase.team;

import co.com.sofka.model.team.gateway.TeamService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteTeamByIdUseCase {

    private final TeamService teamService;

    public Mono<Void> executeDeleteTeamById(String teamId) {
        return this.teamService.deleteTeamById(teamId);
    }
}

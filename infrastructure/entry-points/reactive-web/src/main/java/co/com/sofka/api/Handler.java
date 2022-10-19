package co.com.sofka.api;

import co.com.sofka.model.country.Country;
import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.team.Team;
import co.com.sofka.usecase.country.CreateCountryUseCase;
import co.com.sofka.usecase.cyclist.*;
import co.com.sofka.usecase.team.*;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@AllArgsConstructor
public class Handler {

    private final CreateCountryUseCase createCountryUseCase;
    private final CreateCyclistUseCase createCyclistUseCase;
    private final GetAllCyclistsUseCase getAllCyclistsUseCase;
    private final GetCyclistByIdUseCase getCyclistByIdUseCase;
    private final DeleteCyclistByIdUseCase deleteCyclistByIdUseCase;
    private final GetAllCyclistsByTeamIdUseCase getAllCyclistsByTeamIdUseCase;
    private final GetAllCyclistsByCountryIdUseCase getAllCyclistsByCountryIdUseCase;

    private final CreateTeamUseCase createTeamUseCase;
    private final DeleteTeamByIdUseCase deleteTeamByIdUseCase;
    private final GetAllTeamsUseCase getAllTeamsUseCase;
    private final GetTeamByCodeUseCase getTeamByCodeUseCase;
    private final GetTeamByCountryIdUseCase getTeamByCountryIdUseCase;

    private final GetAllCyclistsByNationalityUseCase getAllCyclistsByNationalityUseCase;

    private static Mono<ServerResponse> getServerResponseMono(Mono<ServerResponse> notFound, Mono<List<Cyclist>> cyclistList) {
        return cyclistList.flatMap(cyclist -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(cyclist))
                .switchIfEmpty(notFound));
    }

    public Mono<ServerResponse> listenCreateCountryUseCase(ServerRequest serverRequest) {
        Mono<Country> countryMono = serverRequest.bodyToMono(Country.class)
                .flatMap(this.createCountryUseCase::executeCountryCreation);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(countryMono, Country.class);
    }

    public Mono<ServerResponse> listenCreateCyclistUseCase(ServerRequest serverRequest) {
        Mono<Cyclist> cyclistMono = serverRequest.bodyToMono(Cyclist.class)
                .flatMap(this.createCyclistUseCase::executeCyclistCreation);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(cyclistMono, Cyclist.class);
    }

    public Mono<ServerResponse> listenGetAllCyclistsUseCase(ServerRequest serverRequest) {
        Flux<Cyclist> cyclistFlux = this.getAllCyclistsUseCase.executeGetAllCyclists();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(cyclistFlux, Cyclist.class);
    }

    public Mono<ServerResponse> listenGetCyclistByIdUseCase(ServerRequest serverRequest) {
        String cyclistId = serverRequest.pathVariable("cyclistId");
        Mono<Cyclist> cyclistMono = this.getCyclistByIdUseCase.executeGetCyclistById(cyclistId);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(cyclistMono, Cyclist.class);
    }

    public Mono<ServerResponse> listenDeleteCyclistByIdUseCase(ServerRequest serverRequest) {
        String cyclistId = serverRequest.pathVariable("cyclistId");
        Mono<Void> deletedCyclist = this.deleteCyclistByIdUseCase.executeDeleteCyclistById(cyclistId);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(deletedCyclist, Cyclist.class);
    }

    public Mono<ServerResponse> listenGetAllCyclistByTeamIdUseCase(ServerRequest serverRequest) {
        String teamId = serverRequest.pathVariable("teamId");
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Flux<Cyclist> cyclistFlux = getAllCyclistsByTeamIdUseCase.executeGetAllCyclistsByTeamIdUseCase(teamId);
        Mono<List<Cyclist>> cyclistList = cyclistFlux.collectList();
        return getServerResponseMono(notFound, cyclistList);
    }

    public Mono<ServerResponse> listenGetAllCyclistByNationalityUseCase(ServerRequest serverRequest) {
        String nationality = serverRequest.pathVariable("nationality");
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Flux<Cyclist> cyclistFlux = this.getAllCyclistsByNationalityUseCase.executeGetAllCyclistsByNationality(nationality);
        Mono<List<Cyclist>> cyclistList = cyclistFlux.collectList();
        return getServerResponseMono(notFound, cyclistList);
    }

    public Mono<ServerResponse> listenGetAllCyclistByCountryIdUseCase(ServerRequest serverRequest) {
        String countryId = serverRequest.pathVariable("countryId");
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Flux<Cyclist> cyclistFlux = this.getAllCyclistsByCountryIdUseCase.executeGetAllCyclistsByCountryId(countryId);
        Mono<List<Cyclist>> cyclistList = cyclistFlux.collectList();
        return getServerResponseMono(notFound, cyclistList);
    }

    public Mono<ServerResponse> listenCreateTeamUseCase(ServerRequest serverRequest) {
        Mono<Team> teamMono = serverRequest.bodyToMono(Team.class)
                .flatMap(this.createTeamUseCase::executeTeamCreation);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(teamMono, Team.class);
    }

    public Mono<ServerResponse> listenGetAllTeamsUseCase(ServerRequest serverRequest) {
        Flux<Team> teamFlux = this.getAllTeamsUseCase.executeGetAllTeams();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(teamFlux, Team.class);
    }

    public Mono<ServerResponse> listenDeleteTeamByIdUseCase(ServerRequest serverRequest) {
        String teamId = serverRequest.pathVariable("teamId");
        Mono<Void> deletedTeam = this.deleteTeamByIdUseCase.executeDeleteTeamById(teamId);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(deletedTeam, Cyclist.class);
    }

    public Mono<ServerResponse> listenGetTeamByCodeUseCase(ServerRequest serverRequest) {
        String teamCode = serverRequest.pathVariable("teamCode");
        Mono<Team> teamMono = this.getTeamByCodeUseCase.executeGetTeamByCode(teamCode);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(teamMono, Team.class);
    }

    public Mono<ServerResponse> listenGetTeamByCountryIdUseCase(ServerRequest serverRequest) {
        String teamCountryId = serverRequest.pathVariable("countryId");
        Mono<Team> teamMono = this.getTeamByCountryIdUseCase.executeGetTeamByCountryId(teamCountryId);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(teamMono, Team.class);
    }
}

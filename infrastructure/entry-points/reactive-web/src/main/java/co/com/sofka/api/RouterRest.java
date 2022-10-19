package co.com.sofka.api;

import co.com.sofka.model.enums.RoutesEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterRest {

    private static final String PATH = "/api/tour";

    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(POST(PATH + RoutesEnum.COUNTRY.getValue()), handler::listenCreateCountryUseCase)

                .and(route(POST(PATH + RoutesEnum.CYCLISTS.getValue()), handler::listenCreateCyclistUseCase))
                .and(route(GET(PATH + RoutesEnum.CYCLISTS.getValue()), handler::listenGetAllCyclistsUseCase))
                .and(route(GET(PATH + RoutesEnum.CYCLISTS.getValue() + RoutesEnum.CYCLIST_ID.getValue()), handler::listenGetCyclistByIdUseCase))
                .and(route(GET(PATH + RoutesEnum.CYCLISTS.getValue() + RoutesEnum.BY_TEAM.getValue() + RoutesEnum.TEAM_ID.getValue()), handler::listenGetAllCyclistByTeamIdUseCase))
                .and(route(GET(PATH + RoutesEnum.CYCLISTS.getValue() + RoutesEnum.BY_COUNTRY.getValue() + RoutesEnum.COUNTRY_ID.getValue()), handler::listenGetAllCyclistByCountryIdUseCase))
                .and(route(GET(PATH + RoutesEnum.CYCLISTS.getValue() + RoutesEnum.BY_NATIONALITY.getValue() + RoutesEnum.NATIONALITY.getValue()), handler::listenGetAllCyclistByNationalityUseCase))
                .and(route(DELETE(PATH + RoutesEnum.CYCLISTS.getValue() + RoutesEnum.CYCLIST_ID.getValue()), handler::listenDeleteCyclistByIdUseCase))

                .and(route(POST(PATH + RoutesEnum.TEAMS.getValue()), handler::listenCreateTeamUseCase))
                .and(route(GET(PATH + RoutesEnum.TEAMS.getValue()), handler::listenGetAllTeamsUseCase))
                .and(route(GET(PATH + RoutesEnum.TEAMS.getValue() + RoutesEnum.BY_TEAM_CODE.getValue() + RoutesEnum.TEAM_CODE.getValue()), handler::listenGetTeamByCodeUseCase))
                .and(route(GET(PATH + RoutesEnum.TEAMS.getValue() + RoutesEnum.BY_COUNTRY.getValue() + RoutesEnum.COUNTRY_ID.getValue()), handler::listenGetTeamByCountryIdUseCase))
                .and(route(DELETE(PATH + RoutesEnum.TEAMS.getValue() + RoutesEnum.TEAM_ID.getValue()), handler::listenDeleteTeamByIdUseCase));
    }
}

package co.com.sofka.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoutesEnum {

    PATH("/api/tour"),
    NATIONALITY("/{nationality}"),
    BY_TEAM("/byTeam"),
    BY_COUNTRY("/byCountry"),
    BY_NATIONALITY("/byNationality"),
    BY_TEAM_CODE("/byTeamCode"),
    TEAMS("/teams"),
    CYCLISTS("/cyclists"),
    TEAM_ID("/{teamId}"),
    CYCLIST_ID("/{cyclistId}"),
    COUNTRY_ID("/{countryId}"),
    TEAM_CODE("/{teamCode}"),
    COUNTRY("/country");

    private final String value;
}

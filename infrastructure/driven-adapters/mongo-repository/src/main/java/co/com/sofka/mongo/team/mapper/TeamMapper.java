package co.com.sofka.mongo.team.mapper;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.team.Team;
import co.com.sofka.mongo.cyclist.data.CyclistDto;
import co.com.sofka.mongo.team.data.TeamDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamMapper {

    public Team mapToEntity(TeamDto teamDto) {
        return Team.builder()
                .id(teamDto.getId())
                .name(teamDto.getName())
                .code(teamDto.getCode())
                .countryId(teamDto.getCountryId())
                .build();
    }

    public TeamDto mapDtoToEntity(Team team) {
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .code(team.getCode())
                .countryId(team.getCountryId())
                .build();
    }

    private List<CyclistDto> cyclistList(List<Cyclist> cyclistDtoList) {
        return cyclistDtoList.stream()
                .map(this::getCyclistList)
                .collect(Collectors.toList());
    }

    private CyclistDto getCyclistList(Cyclist cyclistDto) {
        return CyclistDto.builder()
                .id(cyclistDto.getId())
                .fullName(cyclistDto.getFullName())
                .UCN(cyclistDto.getUCN())
                .teamId(cyclistDto.getTeamId())
                .countryId(cyclistDto.getCountryId())
                .build();
    }
}


package co.com.sofka.mongo.cyclist.mapper;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.mongo.cyclist.data.CyclistDto;
import org.springframework.stereotype.Component;

@Component
public class CyclistMapper {

    public Cyclist mapToEntity(CyclistDto cyclistDto) {
        return Cyclist.builder()
                .id(cyclistDto.getId())
                .fullName(cyclistDto.getFullName())
                .UCN(cyclistDto.getUCN())
                .teamId(cyclistDto.getTeamId())
                .nationality(cyclistDto.getNationality())
                .countryId(cyclistDto.getCountryId())
                .build();
    }

    public CyclistDto mapDtoToEntity(Cyclist cyclist) {
        return CyclistDto.builder()
                .id(cyclist.getId())
                .fullName(cyclist.getFullName())
                .UCN(cyclist.getUCN())
                .teamId(cyclist.getTeamId())
                .nationality(cyclist.getNationality())
                .countryId(cyclist.getCountryId())
                .build();
    }
}

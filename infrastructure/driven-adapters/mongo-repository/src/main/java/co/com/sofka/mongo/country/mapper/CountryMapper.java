package co.com.sofka.mongo.country.mapper;

import co.com.sofka.model.country.Country;
import co.com.sofka.mongo.country.data.CountryDto;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public Country mapToEntity(CountryDto countryDto) {
        return Country.builder()
                .id(countryDto.getId())
                .name(countryDto.getName())
                .build();
    }

    public CountryDto mapDtoToEntity(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }
}

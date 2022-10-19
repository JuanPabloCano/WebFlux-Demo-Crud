package co.com.sofka.usecase.country;

import co.com.sofka.model.country.Country;
import co.com.sofka.model.country.gateway.CountryService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateCountryUseCase {

    private final CountryService countryService;

    public Mono<Country> executeCountryCreation(Country country) {
        return countryService.createCountry(country);
    }
}

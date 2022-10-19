package co.com.sofka.model.country.gateway;

import co.com.sofka.model.country.Country;
import reactor.core.publisher.Mono;

public interface CountryService {

    Mono<Country> createCountry(Country country);
}

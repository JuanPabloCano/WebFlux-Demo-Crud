package co.com.sofka.mongo.country;

import co.com.sofka.model.country.Country;
import co.com.sofka.model.country.gateway.CountryService;
import co.com.sofka.mongo.country.mapper.CountryMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
@Component
public class CountryRepositoryAdapter implements CountryService {

    private final CountryDBRepository countryDBRepository;
    private final CountryMapper countryMapper;

    public CountryRepositoryAdapter(CountryDBRepository countryDBRepository, CountryMapper countryMapper) {
        this.countryDBRepository = countryDBRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public Mono<Country> createCountry(Country country) {
        return this.countryDBRepository.save(this.countryMapper.mapDtoToEntity(country))
                .map(this.countryMapper::mapToEntity)
                .switchIfEmpty(Mono.empty())
                .onErrorResume(Mono::error);
    }
}

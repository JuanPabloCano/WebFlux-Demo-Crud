package co.com.sofka.mongo.country;

import co.com.sofka.mongo.country.data.CountryDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CountryDBRepository extends ReactiveMongoRepository<CountryDto, String> {
}

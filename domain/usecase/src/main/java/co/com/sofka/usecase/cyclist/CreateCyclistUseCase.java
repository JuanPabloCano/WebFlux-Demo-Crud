package co.com.sofka.usecase.cyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateway.CyclistService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateCyclistUseCase {

    private final CyclistService cyclistService;

    public Mono<Cyclist> executeCyclistCreation(Cyclist cyclist) {
        return this.cyclistService.createCyclist(cyclist);
    }
}

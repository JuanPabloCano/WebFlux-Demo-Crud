package co.com.sofka.usecase.cyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateway.CyclistService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GetAllCyclistsUseCase {

    private final CyclistService cyclistService;

    public Flux<Cyclist> executeGetAllCyclists() {
        return this.cyclistService.getAllCyclists();
    }
}

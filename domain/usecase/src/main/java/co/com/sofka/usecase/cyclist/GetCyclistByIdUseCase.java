package co.com.sofka.usecase.cyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateway.CyclistService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetCyclistByIdUseCase {

    private final CyclistService cyclistService;

    public Mono<Cyclist> executeGetCyclistById(String cyclistId){
        return this.cyclistService.findCyclistById(cyclistId);
    }
}

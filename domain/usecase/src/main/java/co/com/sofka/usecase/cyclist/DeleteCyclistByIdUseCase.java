package co.com.sofka.usecase.cyclist;

import co.com.sofka.model.cyclist.gateway.CyclistService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteCyclistByIdUseCase {

    private final CyclistService cyclistService;

    public Mono<Void> executeDeleteCyclistById(String cyclistId) {
        return this.cyclistService.deleteCyclistById(cyclistId);
    }
}

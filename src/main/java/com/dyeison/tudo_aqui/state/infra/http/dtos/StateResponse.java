package com.dyeison.tudo_aqui.state.infra.http.dtos;

import com.dyeison.tudo_aqui.state.domain.entities.State;

import java.util.List;
import java.util.UUID;

public record StateResponse(
        UUID id,
        String name,
        String uf
) {
    public static StateResponse from(State state) {
        return new StateResponse(state.getId(), state.getName(), state.getUf());
    }

    public static List<StateResponse> fromList(List<State> states) {
        return states.stream().map(StateResponse::from).toList();
    }
}

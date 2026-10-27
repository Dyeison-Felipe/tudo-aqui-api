package com.dyeison.tudo_aqui.shared.application.usecase.outputs.state;

import com.dyeison.tudo_aqui.state.domain.entities.State;

import java.util.UUID;

public record StateOutput(UUID id, String name, String uf) {
    public static StateOutput from(State state) {
        return new StateOutput(state.getId(), state.getName(), state.getUf());
    }
}

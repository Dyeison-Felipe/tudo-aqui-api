package com.dyeison.tudo_aqui.shared.infra.presenters.state;

import com.dyeison.tudo_aqui.shared.application.usecase.outputs.state.StateOutput;

import java.util.List;
import java.util.UUID;

public record StatePresenter(UUID id, String name, String uf) {

    public static StatePresenter from(StateOutput state) {
        return new StatePresenter(state.id(), state.name(), state.uf());
    }

    public static List<StatePresenter> from(List<StateOutput> states) {
        return states.stream().map(StatePresenter::from).toList();
    }
}

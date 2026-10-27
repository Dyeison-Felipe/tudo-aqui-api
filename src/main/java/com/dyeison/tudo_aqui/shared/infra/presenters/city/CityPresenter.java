package com.dyeison.tudo_aqui.shared.infra.presenters.city;

import com.dyeison.tudo_aqui.shared.application.usecase.outputs.city.CityOutput;
import com.dyeison.tudo_aqui.shared.infra.presenters.state.StatePresenter;

import java.util.List;
import java.util.UUID;

public record CityPresenter(UUID id, String name, StatePresenter state) {

    public static CityPresenter from(CityOutput city) {
        StatePresenter state = city.state() != null ? StatePresenter.from(city.state()) : null;

        return new CityPresenter(city.id(), city.Name(), state);
    }

    public static List<CityPresenter> from(List<CityOutput> cities) {
        return cities.stream().map(CityPresenter::from).toList();
    }
}

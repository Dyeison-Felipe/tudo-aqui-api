package com.dyeison.tudo_aqui.shared.application.usecase.outputs.city;

import com.dyeison.tudo_aqui.city.domain.entities.City;
import com.dyeison.tudo_aqui.shared.application.usecase.outputs.state.StateOutput;

import java.util.UUID;

public record CityOutput(
        UUID id,
        String Name,
        StateOutput state
) {
    public static CityOutput from(City city) {
        StateOutput state = city.getState() != null ? StateOutput.from(city.getState()) : null;

        return new CityOutput(city.getId(), city.getName(), state);
    }
}

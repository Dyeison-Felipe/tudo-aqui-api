package com.dyeison.tudo_aqui.state.infra.persistence.mapper;

import com.dyeison.tudo_aqui.shared.infra.mapper.Mappers;
import com.dyeison.tudo_aqui.state.domain.entities.State;
import com.dyeison.tudo_aqui.state.infra.persistence.schema.StateSchema;
import org.springframework.stereotype.Component;

@Component
public class StateMapper extends Mappers<State, StateSchema> {

    @Override
    public State toDomain(StateSchema schema) {
        return State.restore(schema.getId(), schema.getName(), schema.getUf());
    }

    @Override
    public StateSchema toSchema(State domain) {
        return new StateSchema(domain.getId(), domain.getName(), domain.getUf());
    }
}

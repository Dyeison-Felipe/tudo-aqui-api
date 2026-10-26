package com.dyeison.tudo_aqui.city.infra.persisntece.mapper;

import com.dyeison.tudo_aqui.city.domain.entities.City;
import com.dyeison.tudo_aqui.city.infra.persisntece.schema.CitySchema;
import com.dyeison.tudo_aqui.shared.infra.mapper.Mappers;
import com.dyeison.tudo_aqui.state.infra.persistence.mapper.StateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CityMapper extends Mappers<City, CitySchema> {

    private final StateMapper stateMapper;

    @Override
    public City toDomain(CitySchema schema) {
        return City.restore(schema.getId(), schema.getName(), stateMapper.toDomain(schema.getState()));
    }

    @Override
    public CitySchema toSchema(City domain) {
        return new CitySchema(domain.getId(), domain.getName(), domain.getState().getId());
    }
}

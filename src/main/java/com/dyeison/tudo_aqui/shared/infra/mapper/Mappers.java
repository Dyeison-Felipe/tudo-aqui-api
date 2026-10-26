package com.dyeison.tudo_aqui.shared.infra.mapper;

import java.util.List;

public abstract class Mappers<D, S> {

    public abstract D toDomain(S schema);

    public abstract S toSchema(D domain);

    public List<D> toDomainList(List<S> schemas) {
        return schemas.stream().map(this::toDomain).toList();
    }

    public List<S> toSchemaList(List<D> domain) {
        return domain.stream().map(this::toSchema).toList();
    }

}

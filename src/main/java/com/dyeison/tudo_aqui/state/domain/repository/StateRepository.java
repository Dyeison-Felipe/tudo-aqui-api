package com.dyeison.tudo_aqui.state.domain.repository;

import com.dyeison.tudo_aqui.state.domain.entities.State;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StateRepository {
    List<State> findAll();

    List<State> search(String term);

    Optional<State> findById(UUID id);

    Optional<State> findByUf(String uf);

    State save(State state);
}

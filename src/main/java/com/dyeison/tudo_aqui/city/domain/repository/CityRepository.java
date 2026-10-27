package com.dyeison.tudo_aqui.city.domain.repository;

import com.dyeison.tudo_aqui.city.domain.entities.City;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CityRepository {
    List<City> search(String s, UUID state);
    Optional<City> findById (UUID id);
}

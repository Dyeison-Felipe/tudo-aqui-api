package com.dyeison.tudo_aqui.city.infra.CityRepositoryImpl;

import com.dyeison.tudo_aqui.city.domain.entities.City;
import com.dyeison.tudo_aqui.city.domain.repository.CityRepository;
import com.dyeison.tudo_aqui.city.infra.persisntece.mapper.CityMapper;
import com.dyeison.tudo_aqui.state.infra.persistence.schema.StateSchema;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public class CityRepositoryImpl implements CityRepository {

    private final EntityManager entityManager;
    private final SimpleJpaRepository<StateSchema, UUID> jpa;
    private final CityMapper cityMapper;


    @Override
    public List<City> search(String s) {
        return List.of();
    }

    @Override
    public City findById(UUID id) {
        return null;
    }
}

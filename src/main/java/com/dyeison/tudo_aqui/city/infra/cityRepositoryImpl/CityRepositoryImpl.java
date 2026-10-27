package com.dyeison.tudo_aqui.city.infra.cityRepositoryImpl;

import com.dyeison.tudo_aqui.city.domain.entities.City;
import com.dyeison.tudo_aqui.city.domain.repository.CityRepository;
import com.dyeison.tudo_aqui.city.infra.persisntece.mapper.CityMapper;
import com.dyeison.tudo_aqui.city.infra.persisntece.schema.CitySchema;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public class CityRepositoryImpl implements CityRepository {

    // Utilizado para query complexa com o createrQuery();
    private final EntityManager entityManager;
    // Utilizada para Cruds simples como findById(), findAll(), existsById(), count();
    private final SimpleJpaRepository<CitySchema, UUID> jpa;
    private final CityMapper cityMapper;

    public CityRepositoryImpl(EntityManager entityManager, CityMapper mapper) {
        this.entityManager = entityManager;
        this.jpa = new SimpleJpaRepository<>(CitySchema.class, entityManager);
        this.cityMapper = mapper;
    }


    @Override
    public List<City> search(String s, UUID state) {
        String term = s.toLowerCase();

        List<CitySchema> schemas = entityManager.createQuery("""
        SELECT c FROM CitySchema c
        JOIN FETCH c.state
        WHERE LOWER(c.name) LIKE :contains
        AND c.stateId = :stateId
        ORDER BY
            CASE
                WHEN LOWER(c.name) LIKE :startsWith THEN 0
                WHEN LOWER(c.name) LIKE :wordStartsWith THEN 1
                ELSE 2
            END,
            c.name""", CitySchema.class)
                .setParameter("contains", "%" + term + "%")
                .setParameter("startsWith", term + "%")
                .setParameter("wordStartsWith", "% " + term + "%")
                .setParameter("stateId", state)
                .getResultList();

        return cityMapper.toDomainList(schemas);
    }

    @Override
    public Optional<City> findById(UUID id) {
        return jpa.findById(id).map(cityMapper::toDomain);
    }
}

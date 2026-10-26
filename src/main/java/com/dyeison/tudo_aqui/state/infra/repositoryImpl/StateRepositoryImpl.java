package com.dyeison.tudo_aqui.state.infra.repositoryImpl;

import com.dyeison.tudo_aqui.state.domain.entities.State;
import com.dyeison.tudo_aqui.state.domain.repository.StateRepository;
import com.dyeison.tudo_aqui.state.infra.persistence.mapper.StateMapper;
import com.dyeison.tudo_aqui.state.infra.persistence.schema.StateSchema;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public class StateRepositoryImpl implements StateRepository {

    private final EntityManager entityManager;
    private final SimpleJpaRepository<StateSchema, UUID> jpa;
    private final StateMapper mapper;

    public StateRepositoryImpl(EntityManager entityManager, StateMapper mapper) {
        this.entityManager = entityManager;
        this.jpa = new SimpleJpaRepository<>(StateSchema.class, entityManager);
        this.mapper = mapper;
    }

    @Override
    public List<State> findAll() {
        return mapper.toDomainList(jpa.findAll());
    }

    @Override
    public List<State> search(String term) {
        List<StateSchema> schemas = entityManager.createQuery("""
                SELECT s FROM StateSchema s WHERE LOWER(s.name) LIKE :name OR s.uf = :uf ORDER BY s.name""", StateSchema.class)
                .setParameter("name", "%" + term.toLowerCase() + "%")
                .setParameter("uf", term.toUpperCase())
                .getResultList();

        return mapper.toDomainList(schemas);
    }

    @Override
    public Optional<State> findById(UUID id) {
        return jpa.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<State> findByUf(String uf) {
        return entityManager.createQuery("SELECT s FROM s WHERE s.ud = :uf", StateSchema.class).setParameter("uf", uf.toUpperCase()).getResultStream().findFirst().map(mapper::toDomain);
    }

    @Override
    @Transactional
    public State save(State state) {
        return mapper.toDomain(jpa.save(mapper.toSchema(state)));
    }
}

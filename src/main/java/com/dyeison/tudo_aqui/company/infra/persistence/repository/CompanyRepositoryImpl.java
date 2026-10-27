package com.dyeison.tudo_aqui.company.infra.persistence.repository;

import com.dyeison.tudo_aqui.city.infra.persisntece.mapper.CityMapper;
import com.dyeison.tudo_aqui.city.infra.persisntece.schema.CitySchema;
import com.dyeison.tudo_aqui.company.domain.entities.Company;
import com.dyeison.tudo_aqui.company.domain.repository.CompanyRepository;
import com.dyeison.tudo_aqui.company.infra.persistence.mapper.CompanyMapper;
import com.dyeison.tudo_aqui.company.infra.persistence.schema.CompanySchema;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class CompanyRepositoryImpl implements CompanyRepository {

    private final EntityManager entityManager;
    private final SimpleJpaRepository<CompanySchema, UUID> jpa;
    private final CompanyMapper companyMapper;

    public CompanyRepositoryImpl(EntityManager entityManager, SimpleJpaRepository<CompanySchema, UUID> jpa, CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
        this.jpa = jpa;
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Company> findById(UUID id) {
        return jpa.findById(id).map(companyMapper::toDomain);
    }

    @Override
    public Optional<Company> findByDocument(String document) {
        return entityManager.createQuery("""
            SELECT c FROM CompanySchema c
            WHERE c.document = :document""", CompanySchema.class)
                .setParameter("document", document)
                .getResultStream()
                .findFirst()
                .map(companyMapper::toDomain);
    }

    @Override
    public void save(Company company) {

    }
}

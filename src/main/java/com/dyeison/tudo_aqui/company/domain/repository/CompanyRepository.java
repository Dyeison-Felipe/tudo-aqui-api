package com.dyeison.tudo_aqui.company.domain.repository;

import com.dyeison.tudo_aqui.company.domain.entities.Company;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository {
    Optional<Company> findById(UUID id);
    Optional<Company> findByDocument(String document);
    void save(Company company);
}

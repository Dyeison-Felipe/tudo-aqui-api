package com.dyeison.tudo_aqui.company.infra.persistence.mapper;

import com.dyeison.tudo_aqui.company.domain.entities.Company;
import com.dyeison.tudo_aqui.company.infra.persistence.schema.CompanySchema;
import com.dyeison.tudo_aqui.shared.infra.mapper.Mappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyMapper extends Mappers<Company, CompanySchema> {


    @Override
    public Company toDomain(CompanySchema schema) {
        return Company.restore(schema.getId(), schema.getPersonType(), schema.getFantasyName(), schema.getDocument(), schema.getLegalName(), schema.getStateRegistration(), schema.getEmail(), schema.getPhone(), schema.getDescription(), schema.getLogoUrl(), schema.getStatus(), schema.getCreatedAt(), schema.getUpdatedAt());
    }

    @Override
    public CompanySchema toSchema(Company domain) {
        return new CompanySchema(domain.getId(), domain.getPersonType(), domain.getFantasyName(), domain.getDocument(), domain.getLegalName(), domain.getStateRegistration(), domain.getEmail(), domain.getPhone(), domain.getDescription(), domain.getLogoUrl(), domain.getStatus(), domain.getCreatedAt(), domain.getUpdatedAt());
    }
}

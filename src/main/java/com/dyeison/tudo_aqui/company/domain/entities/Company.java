package com.dyeison.tudo_aqui.company.domain.entities;

import com.dyeison.tudo_aqui.shared.domain.enums.CompanyStatus;
import com.dyeison.tudo_aqui.shared.domain.enums.PersonType;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Company {

    @EqualsAndHashCode.Include
    private final UUID id;
    private PersonType personType;
    private String fantasyName;
    private String document;
    private String legalName;
    private String stateRegistration;
    private String email;
    private String phone;
    private String description;
    private String logoUrl;
    private CompanyStatus status;
    private Instant createdAt;
    private Instant updatedAt;

    public static Company create(
            PersonType personType,
            String fantasyName,
            String document,
            String legalName,
            String stateRegistration,
            String email,
            String phone,
            String description,
            String logoUrl
    ) {
        Instant now = Instant.now();

        return new Company(
                UUID.randomUUID(),
                personType,
                fantasyName,
                document,
                legalName,
                stateRegistration,
                email,
                phone,
                description,
                logoUrl,
                CompanyStatus.PENDING,
                now,
                now
        );
    }

    public static Company restore(
            UUID id,
            PersonType personType,
            String fantasyName,
            String document,
            String legalName,
            String stateRegistration,
            String email,
            String phone,
            String description,
            String logoUrl,
            CompanyStatus status,
            Instant createdAt,
            Instant updatedAt
    ) {
        return new Company(
                id,
                personType,
                fantasyName,
                document,
                legalName,
                stateRegistration,
                email,
                phone,
                description,
                logoUrl,
                status,
                createdAt,
                updatedAt
        );
    }
}

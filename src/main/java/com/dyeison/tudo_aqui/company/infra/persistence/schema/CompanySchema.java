package com.dyeison.tudo_aqui.company.infra.persistence.schema;

import com.dyeison.tudo_aqui.shared.domain.enums.CompanyStatus;
import com.dyeison.tudo_aqui.shared.domain.enums.PersonType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.dialect.type.PostgreSQLEnumJdbcType;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "company")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CompanySchema {
    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "person_type", nullable = false)
    private PersonType personType;

    @Column(name = "fantasy_name", nullable = false, length = 200)
    private String fantasyName;

    @Column(name = "document", nullable = false, length = 14, unique = true)
    private String document;

    @Column(name = "legal_name", nullable = false, length = 200)
    private String legalName;

    @Column(name = "state_registration", nullable = true, length = 20)
    private String stateRegistration;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;

    @Column(name = "logo_url", nullable = true, columnDefinition = "TEXT")
    private String logoUrl;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "status", nullable = false)
    private CompanyStatus status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMPTZ")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private Instant updatedAt;
}

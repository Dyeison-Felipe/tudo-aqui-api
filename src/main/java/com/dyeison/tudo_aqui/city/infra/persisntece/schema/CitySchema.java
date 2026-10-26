package com.dyeison.tudo_aqui.city.infra.persisntece.schema;

import com.dyeison.tudo_aqui.state.infra.persistence.schema.StateSchema;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "city")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CitySchema {

    @Id
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "state_id", nullable = false)
    private UUID stateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", insertable = false, updatable = false)
    private StateSchema state;

    public CitySchema(UUID id, String name, UUID stateId) {
        this.id = id;
        this.name = name;
        this.stateId = stateId;
    }
}

package com.dyeison.tudo_aqui.city.domain.entities;

import com.dyeison.tudo_aqui.state.domain.entities.State;
import lombok.*;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class City {

    @EqualsAndHashCode.Include
    private final UUID id;
    private final String name;
    private final State state;

    public static City restore(UUID id, String name, State state) {
        return new City(id, name, state);
    }

}

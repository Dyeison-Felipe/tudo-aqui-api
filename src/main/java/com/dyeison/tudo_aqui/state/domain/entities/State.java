package com.dyeison.tudo_aqui.state.domain.entities;

import lombok.*;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class State {

    @EqualsAndHashCode.Include
    private final UUID id;
    private final String name;
    private final String uf;

    public static State restore(UUID id, String name, String uf) {
        return new State(id, name, uf);
    }

}

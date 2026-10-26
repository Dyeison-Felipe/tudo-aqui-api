package com.dyeison.tudo_aqui.state.application.usecases;

import com.dyeison.tudo_aqui.shared.application.usecase.NoInputUseCase;
import com.dyeison.tudo_aqui.state.domain.entities.State;
import com.dyeison.tudo_aqui.state.domain.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListStatesUseCase implements NoInputUseCase<List<State>> {
    private final StateRepository stateRepository;

    @Override
    public List<State> execute() {
        return stateRepository.findAll();
    }
}

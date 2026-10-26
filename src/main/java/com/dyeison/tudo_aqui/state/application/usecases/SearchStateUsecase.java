package com.dyeison.tudo_aqui.state.application.usecases;


import com.dyeison.tudo_aqui.shared.application.usecase.UseCase;
import com.dyeison.tudo_aqui.state.application.usecases.inputs.SearchStatesInput;
import com.dyeison.tudo_aqui.state.domain.entities.State;
import com.dyeison.tudo_aqui.state.domain.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchStateUsecase implements UseCase<SearchStatesInput, List<State>> {

    private final StateRepository stateRepository;

    public List<State> execute(SearchStatesInput input) {
        if (input.term() == null) {
            return stateRepository.findAll();
        }

        return stateRepository.search(input.term());
    }

}

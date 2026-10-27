package com.dyeison.tudo_aqui.city.application.usecases;

import com.dyeison.tudo_aqui.city.domain.repository.CityRepository;
import com.dyeison.tudo_aqui.shared.application.exception.InvalidInputException;
import com.dyeison.tudo_aqui.shared.application.usecase.UseCase;
import com.dyeison.tudo_aqui.shared.application.usecase.inputs.city.SearchCityInput;
import com.dyeison.tudo_aqui.shared.application.usecase.outputs.city.CityOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchCityUseCase implements UseCase<SearchCityInput, List<CityOutput>> {

    private final CityRepository cityRepository;

    public List<CityOutput> execute(SearchCityInput input) {


        if(input.state() == null) {
            throw new InvalidInputException("Selecione um estado para buscar as cidades");
        }

        return cityRepository.search(input.s(), input.state()).stream().map(CityOutput::from).toList();
    }
}

package com.dyeison.tudo_aqui.city.infra.http.controller;

import com.dyeison.tudo_aqui.city.application.usecases.SearchCityUseCase;
import com.dyeison.tudo_aqui.shared.application.usecase.inputs.city.SearchCityInput;
import com.dyeison.tudo_aqui.shared.infra.presenters.city.CityPresenter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/v1/city")
@RequiredArgsConstructor
public class CityController {
    private final SearchCityUseCase searchCityUseCase;

    @GetMapping
    public List<CityPresenter> search(@RequestParam(name = "s", defaultValue = "") String s, @RequestParam(name = "state", required = false) UUID state) {

        SearchCityInput input = new SearchCityInput(s, state);

        return CityPresenter.from(searchCityUseCase.execute(input));
    }
}

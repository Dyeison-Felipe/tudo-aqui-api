package com.dyeison.tudo_aqui.state.infra.http.controller;

import com.dyeison.tudo_aqui.state.application.usecases.ListStatesUseCase;
import com.dyeison.tudo_aqui.state.application.usecases.SearchStateUsecase;
import com.dyeison.tudo_aqui.state.application.usecases.inputs.SearchStatesInput;
import com.dyeison.tudo_aqui.state.infra.http.dtos.StateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/state")
@RequiredArgsConstructor
public class StateController {

    private final SearchStateUsecase searchStateUsecase;

    @GetMapping
    public ResponseEntity<List<StateResponse>> findAll(@RequestParam(required = false) String search) {
        SearchStatesInput input = new SearchStatesInput(search);
        return ResponseEntity.ok(StateResponse.fromList(searchStateUsecase.execute(input)));
    }


}

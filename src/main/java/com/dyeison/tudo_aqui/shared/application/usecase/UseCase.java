package com.dyeison.tudo_aqui.shared.application.usecase;

public interface UseCase<I, O> {

    O execute(I input);
}

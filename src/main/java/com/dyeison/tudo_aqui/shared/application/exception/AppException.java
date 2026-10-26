package com.dyeison.tudo_aqui.shared.application.exception;

import org.springframework.http.HttpStatus;

public abstract class AppException extends RuntimeException {

    protected AppException(String message) {
        super(message);
    }
}

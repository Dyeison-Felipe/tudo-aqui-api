package com.dyeison.tudo_aqui.shared.infra.http.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
        int status,
        String error,
        String message,
        String path,
        Instant timestamp,
        List<FieldError> fields
) {
    public record FieldError(String field, String message){}

    public static ErrorResponse of(int status, String error, String message, String path) {
        return new ErrorResponse(status, error, message, path, Instant.now(), null);
    }

    public static ErrorResponse withFields(int status, String error, String message, String path, List<FieldError> fields) {
        return new ErrorResponse(status, error, message, path, Instant.now(), fields);
    }
}

package com.web.foros.infra.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(IntegrityValidation.class)
    public ResponseEntity errorHandlerDeIntegridad (Exception err) {
        return ResponseEntity.badRequest().body(err.getMessage());
    }
}

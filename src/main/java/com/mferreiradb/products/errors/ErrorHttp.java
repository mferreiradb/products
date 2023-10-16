package com.mferreiradb.products.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ErrorHttp {
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> errorHttp(HttpClientErrorException e) {
        return ResponseEntity.status(e.getStatusCode()).body(e.getStatusText());
    }
}

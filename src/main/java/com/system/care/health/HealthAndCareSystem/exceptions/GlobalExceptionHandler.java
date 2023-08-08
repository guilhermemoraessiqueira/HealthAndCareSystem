package com.system.care.health.HealthAndCareSystem.exceptions;

import com.system.care.health.HealthAndCareSystem.ValidacaoExcepition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidacaoExcepition.class)
    public ResponseEntity<ExceptionResponseDto> validacaoExepition(ValidacaoExcepition ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(new ExceptionResponseDto(ex.getMessage(), ex.getStatusCode()));
    }
}
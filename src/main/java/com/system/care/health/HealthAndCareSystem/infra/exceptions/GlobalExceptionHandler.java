package com.system.care.health.HealthAndCareSystem.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidacaoExcepition.class)
    public ResponseEntity<ExceptionResponseDto> validacaoExepition(ValidacaoExcepition ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(new ExceptionResponseDto(ex.getMessage(), ex.getStatusCode()));
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(GlobalExceptionHandler.DadosErroValidacao::new).toList());
    }

    @ExceptionHandler(FileNotFoundException.class)
    public void erroFile (FileNotFoundException ex){
        System.out.println(ex.getMessage());
    }
    @ExceptionHandler(RuntimeException.class)
    public void erroR (RuntimeException ex){
        System.out.println(ex.getMessage());
    }

    private record DadosErroValidacao(String campo, String mensagem){
        public DadosErroValidacao(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
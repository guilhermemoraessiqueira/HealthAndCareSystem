package com.system.care.health.HealthAndCareSystem;

import lombok.Data;

@Data
public class ValidacaoExcepition extends RuntimeException {

    private String mensagem;

    private int statusCode;

    public ValidacaoExcepition(String mensagem, int statusCode) {
        super(mensagem);
        this.mensagem = mensagem;
        this.statusCode = statusCode;
    }

    public ValidacaoExcepition(String mensagem) {
        super(mensagem);
    }
}
package com.system.care.health.HealthAndCareSystem.validacao.consulta;

import com.system.care.health.HealthAndCareSystem.ValidacaoExcepition;
import com.system.care.health.HealthAndCareSystem.dtos.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAgendamento30Min implements ValidadorAgendamentoDeConsulta{
    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.getHoraDaConsulta();
        if (dataConsulta.getMinute() % 30 != 0){
            throw new ValidacaoExcepition("Horário indisponível! Horários disponíveis de 30 em 30 minutos");
        }
    }
}
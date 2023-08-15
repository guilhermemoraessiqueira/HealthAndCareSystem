package com.system.care.health.HealthAndCareSystem.validation.consultation;

import com.system.care.health.HealthAndCareSystem.ValidacaoExcepition;
import com.system.care.health.HealthAndCareSystem.dtos.consultation.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Component
public class ValidadorDataHora implements ValidadorAgendamentoDeConsulta{

    private static final LocalTime HORARIO_ABERTURA = LocalTime.of(7, 0);
    private static final LocalTime HORARIO_FECHAMENTO = LocalTime.of(19, 0);

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.getHoraDaConsulta();
        var diaDaSemana = dataConsulta.getDayOfWeek();
        var horarioConsulta = dataConsulta.toLocalTime();

        if (diaDaSemana == DayOfWeek.SUNDAY){
            throw new ValidacaoExcepition ("A clínica não atende aos Domingos");
        }
        if (horarioConsulta.isBefore(HORARIO_ABERTURA) ||  horarioConsulta.isAfter(HORARIO_FECHAMENTO)){
            throw new ValidacaoExcepition ("O horário de funcionamento da clínica é das 07:00 às 19:00");
        }
    }
}
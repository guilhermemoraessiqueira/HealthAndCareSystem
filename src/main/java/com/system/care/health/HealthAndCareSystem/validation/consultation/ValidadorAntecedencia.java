package com.system.care.health.HealthAndCareSystem.validation.consultation;

import com.system.care.health.HealthAndCareSystem.ValidacaoExcepition;
import com.system.care.health.HealthAndCareSystem.dtos.consultation.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidadorAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.getHoraDaConsulta();
        var dataAgora = LocalDateTime.now();

        switch (dataConsulta.compareTo(dataAgora)){
            case -1:
                throw new ValidacaoExcepition("A consulta não pode ser agendada para um horário no passado");
            case 0:
                throw new ValidacaoExcepition("A consulta não pode ser agendada para o horário atual");
            case 1:
                if (dataConsulta.isBefore(dataAgora.plusMinutes(30))) {
                    throw new ValidacaoExcepition("A consulta deve ser agendada com 30 minutos de antecedência");
                }
                break;
        }

    }
}
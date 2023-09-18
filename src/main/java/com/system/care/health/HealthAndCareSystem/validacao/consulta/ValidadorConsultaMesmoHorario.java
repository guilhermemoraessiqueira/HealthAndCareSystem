package com.system.care.health.HealthAndCareSystem.validacao.consulta;

import com.system.care.health.HealthAndCareSystem.dtos.consulta.DadosAgendamentoConsulta;
import com.system.care.health.HealthAndCareSystem.infra.exceptions.ValidacaoExcepition;
import com.system.care.health.HealthAndCareSystem.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorConsultaMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndHoraMarcadaAndMotivoCancelamentoIsNull(dados.getIdMedico(), dados.getHoraDaConsulta());
        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoExcepition("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}

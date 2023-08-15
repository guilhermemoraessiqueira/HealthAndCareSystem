package com.system.care.health.HealthAndCareSystem.validation.consultation;

import com.system.care.health.HealthAndCareSystem.ValidacaoExcepition;
import com.system.care.health.HealthAndCareSystem.dtos.consultation.DadosAgendamentoConsulta;
import com.system.care.health.HealthAndCareSystem.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtivoMedico implements ValidadorAgendamentoDeConsulta{

    @Autowired
    MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        if (dados.getIdMedico() == null){
            return;
        }

        var medico = repository.findById(dados.getIdMedico());
        if (medico.get().getAtivo() == false){
            throw new ValidacaoExcepition("Consulta não pode ser agendada com médico inativo");
        }
    }
}
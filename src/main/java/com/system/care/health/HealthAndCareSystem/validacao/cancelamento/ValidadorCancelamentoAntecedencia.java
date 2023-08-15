package com.system.care.health.HealthAndCareSystem.validacao.cancelamento;

import com.system.care.health.HealthAndCareSystem.dtos.consulta.DadosAgendamentoConsulta;
import com.system.care.health.HealthAndCareSystem.dtos.consulta.DadosCancelamentoConsulta;
import com.system.care.health.HealthAndCareSystem.repositories.ConsultaRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorCancelamentoAntecedencia implements ValidadorCancelamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosCancelamentoConsulta dados) {
        var consulta = repository.getReferenceById(dados.getIdConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getHoraMarcada()).toHours();

        if (diferencaEmHoras < 12) {
            throw new ValidationException("Consulta somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }
}

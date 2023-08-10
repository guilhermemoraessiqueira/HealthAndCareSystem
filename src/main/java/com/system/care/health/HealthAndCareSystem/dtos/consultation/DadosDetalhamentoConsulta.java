package com.system.care.health.HealthAndCareSystem.dtos.consultation;

import com.system.care.health.HealthAndCareSystem.models.Consulta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosDetalhamentoConsulta {
    private Long idConsulta;
    private Long idMedico;
    private Long idPaciente;
    private LocalDateTime horaDaConsulta;

    public DadosDetalhamentoConsulta(Consulta consulta) {
        this.idConsulta = consulta.getId();
        this.idMedico = consulta.getMedico().getId();
        this.idPaciente = consulta.getId();
        this.horaDaConsulta = consulta.getHoraMarcada();
    }
}
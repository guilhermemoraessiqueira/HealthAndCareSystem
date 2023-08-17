package com.system.care.health.HealthAndCareSystem.dtos.consulta;

import com.system.care.health.HealthAndCareSystem.enums.EspecialidadeEnum;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosAgendamentoConsulta {
    private Long id;

    private Long idMedico;

    @NotNull
    private Long idPaciente;

    @NotNull(message = "Data da consulta obrigatória")
    @Future
    private LocalDateTime horaDaConsulta;

    @NotNull(message = "Especialidade é obrigatória")
    private EspecialidadeEnum especialidade;
}
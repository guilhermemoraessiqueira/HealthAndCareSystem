package com.system.care.health.HealthAndCareSystem.dtos.medico;

import com.system.care.health.HealthAndCareSystem.enums.EspecialidadeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosMedicosDisponiveis {

    private LocalDateTime horaDaConsulta;
    private EspecialidadeEnum especialidade;
}
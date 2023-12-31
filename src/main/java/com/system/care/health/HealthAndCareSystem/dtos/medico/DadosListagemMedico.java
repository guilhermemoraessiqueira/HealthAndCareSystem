package com.system.care.health.HealthAndCareSystem.dtos.medico;

import com.system.care.health.HealthAndCareSystem.enums.EspecialidadeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosListagemMedico {
    private Long id;
    private String nome;
    private EspecialidadeEnum especialidade;
}
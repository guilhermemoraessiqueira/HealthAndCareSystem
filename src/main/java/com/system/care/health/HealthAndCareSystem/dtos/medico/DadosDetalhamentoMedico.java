package com.system.care.health.HealthAndCareSystem.dtos.medico;

import com.system.care.health.HealthAndCareSystem.enums.EspecialidadeEnum;
import com.system.care.health.HealthAndCareSystem.models.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosDetalhamentoMedico {
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String numeroTelefone;
    private EspecialidadeEnum especialidade;
    private Endereco endereco;
}
package com.system.care.health.HealthAndCareSystem.dtos.medico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosListagemMedico {
    private Long id;
    private String nome;
    private String crm;


}
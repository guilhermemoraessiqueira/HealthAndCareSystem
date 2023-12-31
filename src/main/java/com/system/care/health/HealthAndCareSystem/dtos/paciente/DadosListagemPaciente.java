package com.system.care.health.HealthAndCareSystem.dtos.paciente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosListagemPaciente {
    private String nome;
    private String email;
    private String cpf;
}
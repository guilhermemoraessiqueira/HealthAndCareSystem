package com.system.care.health.HealthAndCareSystem.dtos.paciente;

import com.system.care.health.HealthAndCareSystem.dtos.endereco.DadosEndereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosDetalhamentoPaciente {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String numeroTelefone;
    private DadosEndereco endereco;
    private Long idEndereco;
}
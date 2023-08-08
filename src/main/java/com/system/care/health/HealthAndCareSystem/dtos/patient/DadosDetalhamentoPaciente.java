package com.system.care.health.HealthAndCareSystem.dtos.patient;

import com.system.care.health.HealthAndCareSystem.dtos.address.DadosEndereco;
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
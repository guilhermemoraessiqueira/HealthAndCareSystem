package com.system.care.health.HealthAndCareSystem.dtos.doctor;

import com.system.care.health.HealthAndCareSystem.models.Endereco;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosAtualizacaoMedico {
    private Long id;
    private String nome;
    private String numeroTelefone;
    private Endereco endereco;
}

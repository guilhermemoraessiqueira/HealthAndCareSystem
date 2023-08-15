package com.system.care.health.HealthAndCareSystem.dtos.medico;

import com.system.care.health.HealthAndCareSystem.enums.EspecialidadeEnum;
import com.system.care.health.HealthAndCareSystem.dtos.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosCadastroMedico {
    @NotBlank
    private String nome;
    @NotBlank
    private String senha;
    @NotBlank
    private String email;
    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    private String crm;
    @NotBlank
    private String numeroTelefone;
    @NotNull
    private EspecialidadeEnum especialidade;
    @NotNull
    @Valid
    private DadosEndereco endereco;
}
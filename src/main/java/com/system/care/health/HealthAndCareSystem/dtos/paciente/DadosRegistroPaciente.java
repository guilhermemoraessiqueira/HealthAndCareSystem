package com.system.care.health.HealthAndCareSystem.dtos.paciente;

import com.system.care.health.HealthAndCareSystem.models.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosRegistroPaciente {
    @NotBlank String nome;
    @NotBlank String senha;
    @NotBlank @Email String email;
    @NotBlank String numeroTelefone;
    @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") String cpf;
    @NotNull @Valid Endereco endereco;
}
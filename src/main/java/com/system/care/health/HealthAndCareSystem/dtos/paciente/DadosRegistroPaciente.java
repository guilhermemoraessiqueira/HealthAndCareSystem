package com.system.care.health.HealthAndCareSystem.dtos.paciente;

import com.system.care.health.HealthAndCareSystem.enums.UserRole;
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
    @NotBlank(message = "Nome é obrigatório")
    String nome;

    @NotBlank(message = "Senha é obrigatório")
    String senha;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Formato do email é inválido")
    String email;

    @NotBlank(message = "Telefone é obrigatório")
    String numeroTelefone;

    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}", message = "Formato do CPF é inválido")
    String cpf;

    @NotNull(message = "Dados do endereço são obrigatórios")
    @Valid
    Endereco endereco;

    @NotNull(message = "Role obrigatória!")
    private UserRole role;
}
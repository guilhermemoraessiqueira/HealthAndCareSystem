package com.system.care.health.HealthAndCareSystem.dtos.medico;

import com.system.care.health.HealthAndCareSystem.enums.EspecialidadeEnum;
import com.system.care.health.HealthAndCareSystem.dtos.endereco.DadosEndereco;
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
public class DadosCadastroMedico {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Senha é obrigatório")
    private String senha;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Formato do email é inválido")
    private String email;

    @NotBlank(message = "CRM é obrigatório")
    @Pattern(regexp = "\\d{4,6}", message = "Formato do CRM é inválido")
    private String crm;

    @NotBlank(message = "Telefone é obrigatório")
    private String numeroTelefone;

    @NotNull(message = "Especialidade é obrigatória")
    private EspecialidadeEnum especialidade;

    @NotNull(message = "Dados do endereço são obrigatórios")
    @Valid
    private DadosEndereco endereco;
}
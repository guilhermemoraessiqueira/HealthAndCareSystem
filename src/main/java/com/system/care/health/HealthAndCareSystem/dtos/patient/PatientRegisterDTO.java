package com.system.care.health.HealthAndCareSystem.dtos.patient;

import com.system.care.health.HealthAndCareSystem.models.AddressModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
public record PatientRegisterDTO(
    @NotBlank String name,
    @NotBlank String password,
    @NotBlank @Email String email,
    @NotBlank String phoneNumber,
    @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") String cpf,
    @NotNull @Valid AddressModel address){
}

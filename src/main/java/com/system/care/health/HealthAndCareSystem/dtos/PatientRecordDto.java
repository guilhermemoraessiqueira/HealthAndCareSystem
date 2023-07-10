package com.system.care.health.HealthAndCareSystem.dtos;

import com.system.care.health.HealthAndCareSystem.DataAdress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record PatientRecordDto(@NotBlank String name,
                               @NotBlank String password,
                               @NotBlank String cpf,
                               @NotBlank String email,
                               @NotBlank String phoneNumber,
                               DataAdress adress) {
}

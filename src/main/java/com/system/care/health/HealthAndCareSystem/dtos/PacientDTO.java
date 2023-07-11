package com.system.care.health.HealthAndCareSystem.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacientDTO {
    @NotBlank String name;
    @NotBlank String password;
    @NotBlank String cpf;
    @NotBlank String email;
    @NotBlank String phoneNumber;
    AddressDTO address;

}
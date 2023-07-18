package com.system.care.health.HealthAndCareSystem.dtos.patient;

import com.system.care.health.HealthAndCareSystem.dtos.AddressDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String cpf;
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;
    private AddressDTO address;

}
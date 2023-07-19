package com.system.care.health.HealthAndCareSystem.dtos.doctor;

import com.system.care.health.HealthAndCareSystem.Specialty;
import com.system.care.health.HealthAndCareSystem.dtos.address.AddressDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String crm;
    @NotBlank
    private String phoneNumber;
    @NotNull
    private Specialty specialty;
    private AddressDTO address;
}
package com.system.care.health.HealthAndCareSystem.dtos.doctor;

import com.system.care.health.HealthAndCareSystem.Specialty;
import com.system.care.health.HealthAndCareSystem.dtos.address.AddressDTO;
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
public class DoctorRegisterDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    private String crm;
    @NotBlank
    private String phoneNumber;
    @NotNull
    private Specialty specialty;
    @NotNull
    @Valid
    private AddressDTO address;
}
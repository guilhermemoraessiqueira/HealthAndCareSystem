package com.system.care.health.HealthAndCareSystem.dtos.patient;

import com.system.care.health.HealthAndCareSystem.dtos.AddressDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientReturnDTO {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phoneNumber;
    private AddressDTO address;
    private Long idAddress;
}
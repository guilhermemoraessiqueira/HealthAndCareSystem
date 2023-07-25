package com.system.care.health.HealthAndCareSystem.dtos.doctor;

import com.system.care.health.HealthAndCareSystem.Specialty;
import com.system.care.health.HealthAndCareSystem.models.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDetailsDTO {
    private Long idDoctor;
    private String name;
    private String email;
    private String crm;
    private String phoneNumber;
    private Specialty Specialty;
    private AddressModel address;
}

package com.system.care.health.HealthAndCareSystem.dtos.doctor;

import com.system.care.health.HealthAndCareSystem.models.AddressModel;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorUpdateDTO {
    private Long idDoctor;
    private String name;
    private String phoneNumber;
    private AddressModel address;
}

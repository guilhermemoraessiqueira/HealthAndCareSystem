package com.system.care.health.HealthAndCareSystem.dtos.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorReturnDTO {
    private Long id;
    private String name;
    private String crm;
}
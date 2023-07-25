package com.system.care.health.HealthAndCareSystem.dtos.doctor;

import com.system.care.health.HealthAndCareSystem.models.DoctorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorListDTO {
    private Long id;
    private String name;
    private String crm;


}
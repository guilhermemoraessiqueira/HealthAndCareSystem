package com.system.care.health.HealthAndCareSystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdressDTO {
    //@NotBlank
    String street;
    //@NotBlank
    String neighborhood;
    //@NotBlank
    //@Pattern(regexp = "\\d{8}")
    String zipCode;
    //@NotBlank
    String city;
    String number;
    String complement;
    String state;
}

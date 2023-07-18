package com.system.care.health.HealthAndCareSystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    String street;
    String neighborhood;
    String zipCode;
    String city;
    String number;
    String complement;
    String state;

    public AddressDTO(String street) {
        this.street = street;
    }
}
package com.system.care.health.HealthAndCareSystem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataAdress(@NotBlank
                         String street,
                         @NotBlank
                         String neighborhood,
                         @NotBlank
                         @Pattern(regexp = "\\d{8}")
                         String zipCode,
                         @NotBlank
                         String city,
                         String number,
                         String complement,
                         String state
) {
}

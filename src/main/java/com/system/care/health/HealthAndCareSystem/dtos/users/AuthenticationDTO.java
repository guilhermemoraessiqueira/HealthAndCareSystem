package com.system.care.health.HealthAndCareSystem.dtos.users;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank(message = "Password é obrigatório")
        String login,
        @NotBlank(message = "Password é obrigatório")
        String password) {
}

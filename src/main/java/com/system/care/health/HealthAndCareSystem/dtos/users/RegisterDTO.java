package com.system.care.health.HealthAndCareSystem.dtos.users;

import com.system.care.health.HealthAndCareSystem.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @NotBlank(message = "Login é obrigatório")
        String login,
        @NotBlank(message = "Password é obrigatório")
        String password,
        @NotNull(message = "Role é obrigatório")
        UserRole role) {
}

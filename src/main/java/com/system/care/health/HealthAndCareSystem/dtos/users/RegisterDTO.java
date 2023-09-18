package com.system.care.health.HealthAndCareSystem.dtos.users;

import com.system.care.health.HealthAndCareSystem.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO{
        @NotBlank(message = "Login é obrigatório")
        private String login;
        @NotBlank(message = "Password é obrigatório")
        private String password;
        @NotNull(message = "Role é obrigatório")
        private UserRole role;
}

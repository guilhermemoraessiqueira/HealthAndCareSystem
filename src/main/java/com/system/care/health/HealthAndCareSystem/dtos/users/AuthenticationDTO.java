package com.system.care.health.HealthAndCareSystem.dtos.users;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationDTO{
        @NotBlank(message = "Login é obrigatório")
        private String login;
        @NotBlank(message = "Password é obrigatório")
        private String password;
}

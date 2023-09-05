package com.system.care.health.HealthAndCareSystem.dtos.users;

import com.system.care.health.HealthAndCareSystem.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}

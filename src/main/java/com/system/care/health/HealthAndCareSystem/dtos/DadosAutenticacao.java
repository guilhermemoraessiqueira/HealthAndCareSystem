package com.system.care.health.HealthAndCareSystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosAutenticacao {
    private String email;
    private String senha;
}

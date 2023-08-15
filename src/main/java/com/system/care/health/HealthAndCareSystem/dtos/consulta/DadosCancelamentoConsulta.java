package com.system.care.health.HealthAndCareSystem.dtos.consulta;

import com.system.care.health.HealthAndCareSystem.enums.MotivoCancelamentoEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosCancelamentoConsulta {
    @NotNull
    Long idConsulta;

    @NotNull
    MotivoCancelamentoEnum motivo;
}

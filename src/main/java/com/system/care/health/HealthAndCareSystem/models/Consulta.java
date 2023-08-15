package com.system.care.health.HealthAndCareSystem.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.system.care.health.HealthAndCareSystem.enums.MotivoCancelamentoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_CONSULTA")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    private LocalDateTime horaMarcada;

    @Column(name = "motivo_cancelamento")
    @Enumerated(EnumType.STRING)
    private MotivoCancelamentoEnum motivoCancelamento;

    public Consulta(Long id, Medico medico, Paciente paciente, LocalDateTime horaMarcada, MotivoCancelamentoEnum motivoCancelamento) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.horaMarcada = horaMarcada;
        this.motivoCancelamento = motivoCancelamento;
    }

    public Consulta (Long id, MotivoCancelamentoEnum motivoCancelamentoEnum){
        this.id = id;
        this.motivoCancelamento = motivoCancelamentoEnum;
    }

    public void cancelar(MotivoCancelamentoEnum motivo) {
        this.motivoCancelamento = motivo;
    }

}
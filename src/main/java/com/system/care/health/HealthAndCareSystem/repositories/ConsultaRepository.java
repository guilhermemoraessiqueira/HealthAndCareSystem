package com.system.care.health.HealthAndCareSystem.repositories;

import com.system.care.health.HealthAndCareSystem.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
     boolean existsByPacienteIdAndHoraMarcadaBetween(Long idPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
     boolean existsByMedicoIdAndHoraMarcadaAndMotivoCancelamentoIsNull(Long idMedico, LocalDateTime data);
}
package com.system.care.health.HealthAndCareSystem.repositories;

import com.system.care.health.HealthAndCareSystem.enums.EspecialidadeEnum;
import com.system.care.health.HealthAndCareSystem.models.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query("SELECT m FROM Medico m WHERE m.ativo = true")
    Page<Medico> findAll(Pageable pageable);

    @Query("""
                SELECT m
                FROM Medico m
                LEFT JOIN m.consultas c
                WHERE m.ativo = true
                AND m.especialidade = :especialidadeEnum
                AND (c.horaMarcada IS NULL OR c.horaMarcada != :dateTime)
            """)
    List<Medico> mostrarMedicosDisponiveisNaDataEHora(EspecialidadeEnum especialidadeEnum, LocalDateTime dateTime);

    @Query("""
                SELECT m
                FROM Medico m
                LEFT JOIN m.consultas c
                WHERE m.ativo = true
                AND m.especialidade = :especialidadeEnum
                AND (c.horaMarcada IS NULL OR c.horaMarcada != :dateTime)
            """)
    List<Medico> mostrarMedicosDisponiveisNaDataEHoraA(EspecialidadeEnum especialidadeEnum, LocalDateTime dateTime);

    @Query("""
            SELECT m
            FROM Medico m 
            WHERE m.email = :login
            AND m.ativo = true
        """)
    UserDetails findByEmail(String login);
}
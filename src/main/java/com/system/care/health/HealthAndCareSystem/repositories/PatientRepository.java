package com.system.care.health.HealthAndCareSystem.repositories;

import com.system.care.health.HealthAndCareSystem.dtos.patient.PatientReturnDTO;
import com.system.care.health.HealthAndCareSystem.models.PatientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<PatientModel, Long> {
    Page<PatientModel> findAll(Pageable pageable);

    //resolvendo o select, enquanto isso vou usar o mapper
//    @Query("SELECT new com.system.care.health.HealthAndCareSystem.dtos.patient.PatientReturnDTO(p.id, p.name, p.cpf, p.email, p.phoneNumber) FROM PatientModel p INNER JOIN p.address a WHERE p.active = true")
//    Page<PatientReturnDTO> obterTodos(Pageable pageable);

}
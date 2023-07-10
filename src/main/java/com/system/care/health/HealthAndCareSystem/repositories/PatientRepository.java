package com.system.care.health.HealthAndCareSystem.repositories;

import com.system.care.health.HealthAndCareSystem.models.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<PatientModel, Long> {
}

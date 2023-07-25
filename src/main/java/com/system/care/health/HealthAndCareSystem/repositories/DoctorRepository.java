package com.system.care.health.HealthAndCareSystem.repositories;

import com.system.care.health.HealthAndCareSystem.dtos.doctor.DoctorListDTO;
import com.system.care.health.HealthAndCareSystem.models.DoctorModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {
    @Query("SELECT d FROM Doctor d WHERE d.active = true")
    Page<DoctorModel> findAll(Pageable pageable);
}
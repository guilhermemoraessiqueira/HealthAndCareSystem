package com.system.care.health.HealthAndCareSystem.repositories;

import com.system.care.health.HealthAndCareSystem.models.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<AddressModel, Long>{
}
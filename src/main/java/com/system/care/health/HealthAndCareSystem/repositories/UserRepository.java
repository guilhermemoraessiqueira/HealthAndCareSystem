package com.system.care.health.HealthAndCareSystem.repositories;

import com.system.care.health.HealthAndCareSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);
}

package com.system.care.health.HealthAndCareSystem.controllers;

import com.system.care.health.HealthAndCareSystem.dtos.PacienteDTO;
import com.system.care.health.HealthAndCareSystem.repositories.PatientRepository;
import com.system.care.health.HealthAndCareSystem.services.PatientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;
    @Autowired
    private PatientService patientService;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid PacienteDTO pacienteDTO){
        return ResponseEntity .status(201).body(patientService.save(pacienteDTO));
    }
}

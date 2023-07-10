package com.system.care.health.HealthAndCareSystem.controllers;

import com.system.care.health.HealthAndCareSystem.dtos.PacienteDTO;
import com.system.care.health.HealthAndCareSystem.models.PatientModel;
import com.system.care.health.HealthAndCareSystem.repositories.PatientRepository;
import com.system.care.health.HealthAndCareSystem.services.PatientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<PatientModel>> findAll(){
        return ResponseEntity .status(200).body(patientService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientModel> findById(@PathVariable Long id){
        return ResponseEntity .status(200).body(patientService.findById(id));
    }
}

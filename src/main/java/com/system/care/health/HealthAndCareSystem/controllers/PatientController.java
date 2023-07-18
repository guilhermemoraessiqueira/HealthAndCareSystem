package com.system.care.health.HealthAndCareSystem.controllers;

import com.system.care.health.HealthAndCareSystem.dtos.patient.PatientDTO;
import com.system.care.health.HealthAndCareSystem.dtos.patient.PatientReturnDTO;
import com.system.care.health.HealthAndCareSystem.models.PatientModel;
import com.system.care.health.HealthAndCareSystem.repositories.PatientRepository;
import com.system.care.health.HealthAndCareSystem.services.PatientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;
    @Autowired
    private PatientService patientService;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid PatientDTO patientDTO){
        return ResponseEntity .status(201).body(patientService.save(patientDTO));
    }

    @GetMapping
    public ResponseEntity<Page<PatientReturnDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int itens) {
        Page<PatientReturnDTO> pacientesPage = patientService.getAll(page, itens);
        return ResponseEntity.ok(pacientesPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientReturnDTO> findById(@PathVariable Long id){
        return ResponseEntity .status(200).body(patientService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientModel> update (
            @PathVariable Long id,
            @RequestBody PatientModel patientModel){
        PatientModel updatedPatient = patientService.updateById(id, patientModel);
        if (updatedPatient != null) {
            return ResponseEntity.ok(updatedPatient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
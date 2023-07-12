package com.system.care.health.HealthAndCareSystem.controllers;

import com.system.care.health.HealthAndCareSystem.dtos.PatientDTO;
import com.system.care.health.HealthAndCareSystem.dtos.PatientReturnDTO;
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
    public ResponseEntity<Page<PatientModel>> findAll(@RequestParam("pagina") int pagina,
                                                          @RequestParam("itens") int itens){
        return ResponseEntity .status(200).body(patientService.getAll(pagina, itens));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientReturnDTO> findById(@PathVariable Long id, PatientReturnDTO patientReturnDTO){
        return ResponseEntity .status(200).body(patientService.getById(patientReturnDTO,id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientModel> update (@PathVariable Long id, @RequestBody PatientModel patientModel){
        PatientModel updatedPatient = patientService.updateById(id, patientModel);
        if (updatedPatient != null) {
            return ResponseEntity.ok(updatedPatient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
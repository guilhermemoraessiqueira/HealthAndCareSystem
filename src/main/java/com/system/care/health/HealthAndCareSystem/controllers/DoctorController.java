package com.system.care.health.HealthAndCareSystem.controllers;

import com.system.care.health.HealthAndCareSystem.dtos.doctor.DoctorDTO;
import com.system.care.health.HealthAndCareSystem.dtos.doctor.DoctorReturnDTO;
import com.system.care.health.HealthAndCareSystem.models.DoctorModel;
import com.system.care.health.HealthAndCareSystem.repositories.DoctorRepository;
import com.system.care.health.HealthAndCareSystem.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    DoctorRepository repository;
    @Autowired
    DoctorService doctorService;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DoctorDTO doctorDTO){
        return ResponseEntity .status(201).body(doctorService.save(doctorDTO));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorReturnDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int itens) {
        Page<DoctorReturnDTO> doctorsPage = doctorService.getAll(page,itens);
        return ResponseEntity.ok(doctorsPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorReturnDTO> findById (@PathVariable Long id){
        return ResponseEntity .status(200).body(doctorService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorModel> update (
            @PathVariable Long id,
            @RequestBody DoctorModel doctorModel){
        DoctorModel updateDoctor = doctorService.updateById(id, doctorModel);
        if(updateDoctor!=null){
            return ResponseEntity.ok(updateDoctor);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

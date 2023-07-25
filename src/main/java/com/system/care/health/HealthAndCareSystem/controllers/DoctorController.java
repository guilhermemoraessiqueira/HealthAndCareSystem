package com.system.care.health.HealthAndCareSystem.controllers;

import com.system.care.health.HealthAndCareSystem.dtos.doctor.DoctorDetailsDTO;
import com.system.care.health.HealthAndCareSystem.dtos.doctor.DoctorRegisterDTO;
import com.system.care.health.HealthAndCareSystem.dtos.doctor.DoctorListDTO;
import com.system.care.health.HealthAndCareSystem.dtos.doctor.DoctorUpdateDTO;
import com.system.care.health.HealthAndCareSystem.models.DoctorModel;
import com.system.care.health.HealthAndCareSystem.repositories.DoctorRepository;
import com.system.care.health.HealthAndCareSystem.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity register(@RequestBody @Valid DoctorRegisterDTO doctorRegisterDTO){
        return ResponseEntity .status(201).body(doctorService.save(doctorRegisterDTO));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorListDTO>> getAllDoctors(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int itens) {
        Pageable pageable = PageRequest.of(page, itens);
        Page<DoctorListDTO> activeDoctors = doctorService.getAll(page, itens);
        return ResponseEntity.ok(activeDoctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDetailsDTO> findById (@PathVariable Long id){
        return ResponseEntity .status(200).body(doctorService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        doctorService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }

}

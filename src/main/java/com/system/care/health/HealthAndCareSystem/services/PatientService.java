package com.system.care.health.HealthAndCareSystem.services;

import com.system.care.health.HealthAndCareSystem.dtos.PacienteDTO;
import com.system.care.health.HealthAndCareSystem.models.PatientModel;
import com.system.care.health.HealthAndCareSystem.repositories.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ModelMapper modelMapper;

    public PacienteDTO save(PacienteDTO pacienteDTO){
        PatientModel patientModel= modelMapper.map(pacienteDTO, PatientModel.class);
        return modelMapper.map(patientRepository.save(patientModel), PacienteDTO.class);

    }
}

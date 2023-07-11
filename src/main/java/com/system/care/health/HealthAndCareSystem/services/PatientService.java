package com.system.care.health.HealthAndCareSystem.services;

import com.system.care.health.HealthAndCareSystem.dtos.PacienteDTO;
import com.system.care.health.HealthAndCareSystem.models.PatientModel;
import com.system.care.health.HealthAndCareSystem.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService {

    PatientRepository patientRepository;
    ModelMapper modelMapper;

    public PacienteDTO save(PacienteDTO pacienteDTO){
        PatientModel patientModel= modelMapper.map(pacienteDTO, PatientModel.class);
        return modelMapper.map(patientRepository.save(patientModel), PacienteDTO.class);
    }

    public Page<PatientModel> getAll(int pagina, int itens) {
        return patientRepository.findAll(PageRequest.of(pagina, itens));
    }

    public PatientModel findById(Long id) {
        return patientRepository.findById(id).get();
    }

    public PatientModel updateById(Long id, PatientModel patient) {
        PatientModel existingPatient = patientRepository.findById(id).orElse(null);
        if (existingPatient != null) {
            existingPatient.setName(patient.getName());
            existingPatient.setCpf(patient.getCpf());
            existingPatient.setEmail(patient.getEmail());
            existingPatient.setPassword(patient.getPassword());
            existingPatient.setPhoneNumber(patient.getPhoneNumber());
            existingPatient.getAddress().setNumber(patient.getAddress().getNumber());
            existingPatient.getAddress().setStreet(patient.getAddress().getStreet());
            existingPatient.getAddress().setNeighborhood(patient.getAddress().getNeighborhood());
            existingPatient.getAddress().setComplement(patient.getAddress().getComplement());
            existingPatient.getAddress().setZipCode(patient.getAddress().getZipCode());
            return patientRepository.save(existingPatient);
        }
        return null;
    }


    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}

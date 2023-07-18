package com.system.care.health.HealthAndCareSystem.services;

import com.system.care.health.HealthAndCareSystem.dtos.patient.PatientDTO;
import com.system.care.health.HealthAndCareSystem.dtos.patient.PatientReturnDTO;
import com.system.care.health.HealthAndCareSystem.models.PatientModel;
import com.system.care.health.HealthAndCareSystem.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientService {
    PatientRepository patientRepository;
    ModelMapper modelMapper;

    public PatientDTO save(PatientDTO patientDTO){
        PatientModel patientModel= modelMapper.map(patientDTO, PatientModel.class);
        return modelMapper.map(patientRepository.save(patientModel), PatientDTO.class);
    }

    public Page<PatientReturnDTO> getAll(int page, int itens) {
        return patientRepository.findAll(PageRequest.of(page, itens)).map(this::convertToPatientReturnDTO);
        //return patientRepository.obterTodos(PageRequest.of(pagina, itens));
    }

    public PatientReturnDTO getById(Long id) {
        return modelMapper.map(patientRepository.findById(id), PatientReturnDTO.class);
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
    private PatientReturnDTO convertToPatientReturnDTO(PatientModel paciente) {
        PatientReturnDTO patientReturnDTO = modelMapper.map(paciente, PatientReturnDTO.class);
        return patientReturnDTO;
    }
}
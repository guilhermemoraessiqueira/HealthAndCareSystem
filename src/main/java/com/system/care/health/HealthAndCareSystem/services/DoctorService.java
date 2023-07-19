package com.system.care.health.HealthAndCareSystem.services;

import com.system.care.health.HealthAndCareSystem.dtos.doctor.DoctorDTO;
import com.system.care.health.HealthAndCareSystem.dtos.doctor.DoctorReturnDTO;
import com.system.care.health.HealthAndCareSystem.models.DoctorModel;
import com.system.care.health.HealthAndCareSystem.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorService {

    DoctorRepository doctorRepository;
    ModelMapper modelMapper;

    public DoctorDTO save (DoctorDTO doctorDTO){
        DoctorModel doctorModel= modelMapper.map(doctorDTO, DoctorModel.class);
        return modelMapper.map(doctorRepository.save(doctorModel), DoctorDTO.class);

    }
    public DoctorReturnDTO getById(Long id){
        return modelMapper.map(doctorRepository.findById(id), DoctorReturnDTO.class);
    }

    public Page<DoctorReturnDTO> getAll(int page, int itens) {
        return doctorRepository.findAll(PageRequest.of(page,itens)).map(this::convertToPatientReturnDTO);
    }

    private DoctorReturnDTO convertToPatientReturnDTO(DoctorModel doctor) {
        DoctorReturnDTO doctorReturnDTO = modelMapper.map(doctor, DoctorReturnDTO.class);
        return doctorReturnDTO;
    }

    public DoctorModel updateById(Long id, DoctorModel doctorModel) {
        DoctorModel existingDoctor = doctorRepository.findById(id).orElse(null);
        if (existingDoctor != null) {
            existingDoctor.setName(doctorModel.getName());
            existingDoctor.setPassword(doctorModel.getPassword());
            existingDoctor.setCrm(doctorModel.getCrm());
            existingDoctor.setSpecialty(doctorModel.getSpecialty());
            existingDoctor.setPhoneNumber(doctorModel.getPhoneNumber());
            existingDoctor.getAddress().setNumber(doctorModel.getAddress().getNumber());
            existingDoctor.getAddress().setStreet(doctorModel.getAddress().getStreet());
            existingDoctor.getAddress().setNeighborhood(doctorModel.getAddress().getNeighborhood());
            existingDoctor.getAddress().setComplement(doctorModel.getAddress().getComplement());
            existingDoctor.getAddress().setZipCode(doctorModel.getAddress().getZipCode());
            return doctorRepository.save(existingDoctor);
        }
        return null;
    }

    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}
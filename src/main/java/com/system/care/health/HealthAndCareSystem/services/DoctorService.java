package com.system.care.health.HealthAndCareSystem.services;

import com.system.care.health.HealthAndCareSystem.dtos.doctor.DoctorDetailsDTO;
import com.system.care.health.HealthAndCareSystem.dtos.doctor.DoctorRegisterDTO;
import com.system.care.health.HealthAndCareSystem.dtos.doctor.DoctorListDTO;
import com.system.care.health.HealthAndCareSystem.dtos.doctor.DoctorUpdateDTO;
import com.system.care.health.HealthAndCareSystem.models.DoctorModel;
import com.system.care.health.HealthAndCareSystem.repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService{

    DoctorRepository doctorRepository;
    ModelMapper modelMapper;

    public DoctorRegisterDTO save (DoctorRegisterDTO doctorRegisterDTO){
        DoctorModel doctorModel= modelMapper.map(doctorRegisterDTO, DoctorModel.class);
        return modelMapper.map(doctorRepository.save(doctorModel), DoctorRegisterDTO.class);
    }
    public DoctorDetailsDTO getById(Long id){
        return modelMapper.map(doctorRepository.findById(id), DoctorDetailsDTO.class);
    }


    public Page<DoctorListDTO> getAll(int page, int itens) {
        return doctorRepository.findAll(PageRequest.of(page, itens)).map(this::convertToPatientReturnDTO);
    }

    public DoctorModel updateById(Long id, DoctorUpdateDTO doctorUpdateDTO) {
        DoctorModel existingDoctor = doctorRepository.findById(id).orElse(null);
        if (existingDoctor != null) {
            existingDoctor.setName(doctorUpdateDTO.getName());
            existingDoctor.setPhoneNumber(doctorUpdateDTO.getPhoneNumber());
            existingDoctor.getAddress().setNumber(doctorUpdateDTO.getAddress().getNumber());
            existingDoctor.getAddress().setStreet(doctorUpdateDTO.getAddress().getStreet());
            existingDoctor.getAddress().setNeighborhood(doctorUpdateDTO.getAddress().getNeighborhood());
            existingDoctor.getAddress().setComplement(doctorUpdateDTO.getAddress().getComplement());
            existingDoctor.getAddress().setZipCode(doctorUpdateDTO.getAddress().getZipCode());
            return doctorRepository.save(existingDoctor);
        }
        return null;
    }
    @Transactional
    public void deletarMedico(Long id) {
        var medico = doctorRepository.getReferenceById(id);
        medico.excluir();
    }

    private DoctorListDTO convertToPatientReturnDTO(DoctorModel doctorModel) {
        DoctorListDTO doctorListDTO = modelMapper.map(doctorModel, DoctorListDTO.class);
        return doctorListDTO;
    }
}
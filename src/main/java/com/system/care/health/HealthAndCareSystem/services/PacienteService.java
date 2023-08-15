package com.system.care.health.HealthAndCareSystem.services;

import com.system.care.health.HealthAndCareSystem.dtos.paciente.DadosListagemPaciente;
import com.system.care.health.HealthAndCareSystem.dtos.paciente.DadosRegistroPaciente;
import com.system.care.health.HealthAndCareSystem.dtos.paciente.DadosDetalhamentoPaciente;
import com.system.care.health.HealthAndCareSystem.models.Paciente;
import com.system.care.health.HealthAndCareSystem.repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PacienteService {
    PacienteRepository pacienteRepository;
    ModelMapper modelMapper;

    public DadosRegistroPaciente cadastrarPaciente(DadosRegistroPaciente dadosRegistroPaciente){
        Paciente paciente = modelMapper.map(dadosRegistroPaciente, Paciente.class);
        return modelMapper.map(pacienteRepository.save(paciente), DadosRegistroPaciente.class);
    }

    public Page<DadosListagemPaciente> listarPacientes(int page, int itens) {
        return pacienteRepository.findAll(PageRequest.of(page, itens)).map(this::convertToPatientReturnDTO);
        //return pacienteRepository.obterTodos(PageRequest.of(pagina, itens));
    }

    public DadosDetalhamentoPaciente detalharPaciente(Long id) {
        return modelMapper.map(pacienteRepository.findById(id), DadosDetalhamentoPaciente.class);
    }

    public Paciente atualizarPaciente(Long id, Paciente patient) {
        Paciente existingPatient = pacienteRepository.findById(id).orElse(null);
        if (existingPatient != null) {
            existingPatient.setNome(patient.getNome());
            existingPatient.setCpf(patient.getCpf());
            existingPatient.setEmail(patient.getEmail());
            existingPatient.setSenha(patient.getSenha());
            existingPatient.setNumeroTelefone(patient.getNumeroTelefone());
            existingPatient.getEndereco().setNumero(patient.getEndereco().getNumero());
            existingPatient.getEndereco().setRua(patient.getEndereco().getRua());
            existingPatient.getEndereco().setBairro(patient.getEndereco().getBairro());
            existingPatient.getEndereco().setComplemento(patient.getEndereco().getComplemento());
            existingPatient.getEndereco().setCep(patient.getEndereco().getCep());
            return pacienteRepository.save(existingPatient);
        }
        return null;
    }

    public void deletarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
    private DadosListagemPaciente convertToPatientReturnDTO(Paciente paciente) {
        DadosListagemPaciente dadosListagemPaciente = modelMapper.map(paciente, DadosListagemPaciente.class);
        return dadosListagemPaciente;
    }
}
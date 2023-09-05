package com.system.care.health.HealthAndCareSystem.services;

import com.system.care.health.HealthAndCareSystem.dtos.medico.*;
import com.system.care.health.HealthAndCareSystem.models.Medico;
import com.system.care.health.HealthAndCareSystem.models.User;
import com.system.care.health.HealthAndCareSystem.repositories.MedicoRepository;
import com.system.care.health.HealthAndCareSystem.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedicoService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MedicoRepository medicoRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    public DadosCadastroMedico salvarMedico (DadosCadastroMedico data){
        Medico medico = modelMapper.map(data, Medico.class);
        String encryptedPassword = passwordEncoder.encode(data.getSenha());

        User newUser = new User(data.getEmail(), encryptedPassword, data.getRole());
        userRepository.save(newUser);
        return modelMapper.map(medicoRepository.save(medico), DadosCadastroMedico.class);
    }
    public DadosDetalhamentoMedico detalharMedico(Long id){
        return modelMapper.map(medicoRepository.getReferenceById(id), DadosDetalhamentoMedico.class);
    }


    public Page<DadosListagemMedico> listaMedicos(int page, int itens) {
        return medicoRepository.findAll(PageRequest.of(page, itens)).map(this::convertToReturnDTO);
    }
    public List<DadosListagemMedico> listaMedicosDisponiveis(DadosMedicosDisponiveis dadosMedicosDisponiveis,
                                                             int page, int itens) {
        var medico = medicoRepository.mostrarMedicosDisponiveisNaDataEHoraA(dadosMedicosDisponiveis.getEspecialidade(),
                dadosMedicosDisponiveis.getHoraDaConsulta());
        return listaMedicosDisponiveis(medico);
    }

    public List<DadosListagemMedico> listaMedicosDisponiveis(List<Medico> medicos) {
        return medicos.stream()
                .map(medico -> modelMapper.map(medico, DadosListagemMedico.class))
                .collect(Collectors.toList());
    }

    public Medico atualizarMedico(Long id, DadosAtualizacaoMedico dadosAtualizacaoMedico) {
        Medico medicoExistente = medicoRepository.findById(id).orElse(null);
        if (medicoExistente != null) {
            medicoExistente.setNome(dadosAtualizacaoMedico.getNome());
            medicoExistente.setNumeroTelefone(dadosAtualizacaoMedico.getNumeroTelefone());
            medicoExistente.getEndereco().setNumero(dadosAtualizacaoMedico.getEndereco().getNumero());
            medicoExistente.getEndereco().setRua(dadosAtualizacaoMedico.getEndereco().getRua());
            medicoExistente.getEndereco().setBairro(dadosAtualizacaoMedico.getEndereco().getBairro());
            medicoExistente.getEndereco().setComplemento(dadosAtualizacaoMedico.getEndereco().getComplemento());
            medicoExistente.getEndereco().setCep(dadosAtualizacaoMedico.getEndereco().getCep());
            return medicoRepository.save(medicoExistente);
        }
        return null;
    }
    @Transactional
    public void deletarMedico(Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }

    private DadosListagemMedico convertToReturnDTO(Medico medico) {
        DadosListagemMedico dadosListagemMedico = modelMapper.map(medico, DadosListagemMedico.class);
        return dadosListagemMedico;
    }
}
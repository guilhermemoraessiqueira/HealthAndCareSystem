package com.system.care.health.HealthAndCareSystem.services;

import com.system.care.health.HealthAndCareSystem.dtos.medico.DadosDetalhamentoMedico;
import com.system.care.health.HealthAndCareSystem.dtos.medico.DadosCadastroMedico;
import com.system.care.health.HealthAndCareSystem.dtos.medico.DadosListagemMedico;
import com.system.care.health.HealthAndCareSystem.dtos.medico.DadosAtualizacaoMedico;
import com.system.care.health.HealthAndCareSystem.models.Medico;
import com.system.care.health.HealthAndCareSystem.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicoService {

    MedicoRepository medicoRepository;
    ModelMapper modelMapper;

    public DadosCadastroMedico salvarMedico (DadosCadastroMedico dadosCadastroMedico){
        Medico medico = modelMapper.map(dadosCadastroMedico, Medico.class);
        return modelMapper.map(medicoRepository.save(medico), DadosCadastroMedico.class);
    }
    public DadosDetalhamentoMedico detalharMedico(Long id){
        return modelMapper.map(medicoRepository.findById(id), DadosDetalhamentoMedico.class);
    }


    public Page<DadosListagemMedico> listaMedicos(int page, int itens) {
        return medicoRepository.findAll(PageRequest.of(page, itens)).map(this::convertToPatientReturnDTO);
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

    private DadosListagemMedico convertToPatientReturnDTO(Medico medico) {
        DadosListagemMedico dadosListagemMedico = modelMapper.map(medico, DadosListagemMedico.class);
        return dadosListagemMedico;
    }
}
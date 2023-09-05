package com.system.care.health.HealthAndCareSystem.services;

import com.system.care.health.HealthAndCareSystem.infra.exceptions.ValidacaoExcepition;
import com.system.care.health.HealthAndCareSystem.dtos.consulta.DadosAgendamentoConsulta;
import com.system.care.health.HealthAndCareSystem.dtos.consulta.DadosCancelamentoConsulta;
import com.system.care.health.HealthAndCareSystem.dtos.consulta.DadosDetalhamentoConsulta;
import com.system.care.health.HealthAndCareSystem.models.Consulta;
import com.system.care.health.HealthAndCareSystem.models.Medico;
import com.system.care.health.HealthAndCareSystem.repositories.ConsultaRepository;
import com.system.care.health.HealthAndCareSystem.repositories.MedicoRepository;
import com.system.care.health.HealthAndCareSystem.repositories.PacienteRepository;
import com.system.care.health.HealthAndCareSystem.validacao.cancelamento.ValidadorCancelamentoDeConsulta;
import com.system.care.health.HealthAndCareSystem.validacao.consulta.ValidadorAgendamentoDeConsulta;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ConsultaService {

    private ConsultaRepository consultaRepository;

    private MedicoRepository medicoRepository;

    private PacienteRepository pacienteRepository;

    private List<ValidadorAgendamentoDeConsulta> validadores;

    private List<ValidadorCancelamentoDeConsulta> validadoresCancelamento;

    public DadosDetalhamentoConsulta agendarConsulta(DadosAgendamentoConsulta dados){

        if (!pacienteRepository.existsById(dados.getIdMedico())) {
            throw new ValidacaoExcepition("Id do paciente informado não existente");
        }
        if (dados.getIdMedico() != null && !medicoRepository.existsById(dados.getIdPaciente())) {
            throw new ValidacaoExcepition("Id do médico informado não existe!");
        }

        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.getIdPaciente());
        var medicos = escolherMedico(dados);

        if (medicos == null) {
            throw new ValidacaoExcepition("Não existe médico disponível nessa data!");
        }

        var consulta = new Consulta(null, medicos.get(0), paciente, dados.getHoraDaConsulta(), null);
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);

    }

    public void cancelar(DadosCancelamentoConsulta dados) {
        if (!consultaRepository.existsById(dados.getIdConsulta())) {
            throw new ValidacaoExcepition("Id da consulta informado não existe!");
        }

        validadoresCancelamento.forEach(v -> v.validar(dados));

        var consulta = consultaRepository.getReferenceById(dados.getIdConsulta());
        consulta.cancelar(dados.getMotivo());
        consultaRepository.save(consulta);
    }

    private List<Medico> escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.getIdMedico() == null) {
            throw new ValidacaoExcepition("O id do médico não foi informado", HttpStatus.UNAUTHORIZED.value());
            //return new ArrayList<>();
        }

        if (dados.getEspecialidade() == null) {
            throw new ValidacaoExcepition("Especialidade é obrigatória quando médico não for escolhido!");
        }

        return medicoRepository.mostrarMedicosDisponiveisNaDataEHora(dados.getEspecialidade(), dados.getHoraDaConsulta());
    }
}
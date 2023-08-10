package com.system.care.health.HealthAndCareSystem.services;

import com.system.care.health.HealthAndCareSystem.ValidacaoExcepition;
import com.system.care.health.HealthAndCareSystem.dtos.consultation.DadosAgendamentoConsulta;
import com.system.care.health.HealthAndCareSystem.dtos.consultation.DadosDetalhamentoConsulta;
import com.system.care.health.HealthAndCareSystem.models.Consulta;
import com.system.care.health.HealthAndCareSystem.models.Medico;
import com.system.care.health.HealthAndCareSystem.repositories.ConsultaRepository;
import com.system.care.health.HealthAndCareSystem.repositories.MedicoRepository;
import com.system.care.health.HealthAndCareSystem.repositories.PacienteRepository;
import com.system.care.health.HealthAndCareSystem.validation.consultation.ValidadorAgendamentoDeConsulta;
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

    private List<ValidadorAgendamentoDeConsulta> validation;

    public DadosDetalhamentoConsulta agendarConsulta(DadosAgendamentoConsulta dados) {
        if (!pacienteRepository.existsById(dados.getIdPaciente())) {
            throw new ValidacaoExcepition("Id do paciente informado não existente");
        }
        if (dados.getIdMedico() != null && !medicoRepository.existsById(dados.getIdPaciente())) {
            throw new ValidacaoExcepition("Id do médico informado não existe!");
        }

        //validation.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.getIdPaciente());
        var medicos = escolherMedico(dados);

        if (medicos == null) {
            throw new ValidacaoExcepition("Não existe médico disponível nessa data!");
        }

        var consulta = new Consulta(null, medicos.get(0), paciente, dados.getHoraDaConsulta(), null);
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
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
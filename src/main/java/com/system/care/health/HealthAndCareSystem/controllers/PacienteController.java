package com.system.care.health.HealthAndCareSystem.controllers;

import com.system.care.health.HealthAndCareSystem.dtos.paciente.DadosListagemPaciente;
import com.system.care.health.HealthAndCareSystem.dtos.paciente.DadosRegistroPaciente;
import com.system.care.health.HealthAndCareSystem.dtos.paciente.DadosDetalhamentoPaciente;
import com.system.care.health.HealthAndCareSystem.models.Paciente;
import com.system.care.health.HealthAndCareSystem.repositories.PacienteRepository;
import com.system.care.health.HealthAndCareSystem.services.PacienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosRegistroPaciente dadosRegistroPaciente){
        return ResponseEntity .status(201).body(pacienteService.cadastrarPaciente(dadosRegistroPaciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int itens) {
        Page<DadosListagemPaciente> pacientesPage = pacienteService.listarPacientes(page, itens);
        return ResponseEntity.ok(pacientesPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoPaciente> detalhar(@PathVariable Long id){
        return ResponseEntity .status(200).body(pacienteService.detalharPaciente(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizar (
            @PathVariable Long id,
            @RequestBody Paciente paciente){
        Paciente pacienteAtualizado = pacienteService.atualizarPaciente(id, paciente);
        if (pacienteAtualizado != null) {
            return ResponseEntity.ok(pacienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }
}
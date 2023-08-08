package com.system.care.health.HealthAndCareSystem.controllers;

import com.system.care.health.HealthAndCareSystem.dtos.doctor.DadosDetalhamentoMedico;
import com.system.care.health.HealthAndCareSystem.dtos.doctor.DadosCadastroMedico;
import com.system.care.health.HealthAndCareSystem.dtos.doctor.DadosListagemMedico;
import com.system.care.health.HealthAndCareSystem.models.Paciente;
import com.system.care.health.HealthAndCareSystem.repositories.MedicoRepository;
import com.system.care.health.HealthAndCareSystem.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    MedicoRepository repository;

    @Autowired
    MedicoService medicoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dadosCadastroMedico){
        return ResponseEntity .status(201).body(medicoService.salvarMedico(dadosCadastroMedico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "10") int itens) {
        Pageable pageable = PageRequest.of(page, itens);
        Page<DadosListagemMedico> medicosAtivos = medicoService.listaMedicos(page, itens);
        return ResponseEntity.ok(medicosAtivos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoMedico> detalhar (@PathVariable Long id){
        return ResponseEntity .status(200).body(medicoService.detalharMedico(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }

    //fazer atualizarMedico
}
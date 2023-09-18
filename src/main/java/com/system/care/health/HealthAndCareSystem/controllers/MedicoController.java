package com.system.care.health.HealthAndCareSystem.controllers;

import com.system.care.health.HealthAndCareSystem.dtos.medico.DadosCadastroMedico;
import com.system.care.health.HealthAndCareSystem.dtos.medico.DadosDetalhamentoMedico;
import com.system.care.health.HealthAndCareSystem.dtos.medico.DadosListagemMedico;
import com.system.care.health.HealthAndCareSystem.dtos.medico.DadosMedicosDisponiveis;
import com.system.care.health.HealthAndCareSystem.repositories.MedicoRepository;
import com.system.care.health.HealthAndCareSystem.services.MedicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medico")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    MedicoRepository repository;

    @Autowired
    MedicoService medicoService;

    @GetMapping("/disponiveis")
    public ResponseEntity<List<DadosListagemMedico>> listarMedicosDisponiveis(@RequestParam(defaultValue = "0") int page,
                                                                              @RequestParam(defaultValue = "10") int itens,
                                                                              @RequestBody DadosMedicosDisponiveis dadosMedicosDisponiveis){
        Pageable pageable = PageRequest.of(page, itens);
        List<DadosListagemMedico> medicosDisponiveis = medicoService.listaMedicosDisponiveis(dadosMedicosDisponiveis, page, itens);
        return ResponseEntity.ok(medicosDisponiveis);
    }

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
}
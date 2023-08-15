package com.system.care.health.HealthAndCareSystem.controllers;

import com.system.care.health.HealthAndCareSystem.dtos.consulta.DadosAgendamentoConsulta;
import com.system.care.health.HealthAndCareSystem.dtos.consulta.DadosCancelamentoConsulta;
import com.system.care.health.HealthAndCareSystem.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consulta")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    @PostMapping
    public ResponseEntity agendar(@RequestBody DadosAgendamentoConsulta dados) {
        var dto = consultaService.agendarConsulta(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    public ResponseEntity cancelar (@RequestBody DadosCancelamentoConsulta dados){
        consultaService.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
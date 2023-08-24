package com.system.care.health.HealthAndCareSystem.controllers;


import com.system.care.health.HealthAndCareSystem.dtos.DadosAutenticacao;
import com.system.care.health.HealthAndCareSystem.infra.security.DadosTokenJWT;
import com.system.care.health.HealthAndCareSystem.infra.security.TokenService;
import com.system.care.health.HealthAndCareSystem.models.Medico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("login/medico")
@RestController
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login (@RequestBody @Valid DadosAutenticacao dados){
        var authenticationTokenoken = new UsernamePasswordAuthenticationToken(dados.getEmail(), dados.getSenha());
        var authentication = manager.authenticate(authenticationTokenoken);
        var tokenJWT = tokenService.gerarToken((Medico)authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
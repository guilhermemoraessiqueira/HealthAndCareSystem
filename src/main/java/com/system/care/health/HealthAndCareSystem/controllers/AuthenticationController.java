package com.system.care.health.HealthAndCareSystem.controllers;

import com.system.care.health.HealthAndCareSystem.dtos.users.AuthenticationDTO;
import com.system.care.health.HealthAndCareSystem.dtos.users.LoginDTO;
import com.system.care.health.HealthAndCareSystem.dtos.users.RegisterDTO;
import com.system.care.health.HealthAndCareSystem.infra.security.TokenService;
import com.system.care.health.HealthAndCareSystem.models.User;
import com.system.care.health.HealthAndCareSystem.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository repository;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User)auth.getPrincipal());

        return ResponseEntity.ok(new LoginDTO(token));

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if (this.repository.findByLogin(data.getLogin()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        User newUser = new User (data.getLogin(), encryptedPassword, data.getRole());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}

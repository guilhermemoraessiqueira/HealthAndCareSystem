package com.system.care.health.HealthAndCareSystem.models;

import com.system.care.health.HealthAndCareSystem.dtos.address.DadosEndereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua; // Logradouro
    private String bairro; // Bairro
    private String cep; // CEP
    private String numero; // Número
    private String complemento; // Complemento
    private String cidade; // Cidade
    private String estado; // UF

    public Endereco(DadosEndereco dados) {
        this.rua = dados.getRua();
        this.bairro = dados.getBairro();
        this.cep = dados.getCep();
        this.cidade = dados.getCidade();
        this.numero = dados.getNumero();
        this.complemento = dados.getComplemento();
        this.estado = dados.getEstado();
    }
}
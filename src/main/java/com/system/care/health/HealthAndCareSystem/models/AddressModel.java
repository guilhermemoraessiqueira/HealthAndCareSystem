package com.system.care.health.HealthAndCareSystem.models;

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
@Table(name = "address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street; // Logradouro
    private String neighborhood; // Bairro
    private String zipCode; // CEP
    private String number; // Número
    private String complement; // Complemento
    private String city; // Cidade
    private String state; // UF
}
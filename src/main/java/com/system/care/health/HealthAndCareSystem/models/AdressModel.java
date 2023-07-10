package com.system.care.health.HealthAndCareSystem.models;

import com.system.care.health.HealthAndCareSystem.DataAdress;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdressModel {

    private String street; // Logradouro
    private String neighborhood; // Bairro
    private String zipCode; // CEP
    private String number; // Número
    private String complement; // Complemento
    private String city; // Cidade
    private String state; // UF

    public AdressModel(DataAdress adress){
        this.street= adress.street();
        this.neighborhood= adress.neighborhood();
        this.zipCode= adress.zipCode();
        this.number= adress.number();
        this.complement= adress.complement();
        this.city= adress.city();
        this.state= adress.state();
    }
}

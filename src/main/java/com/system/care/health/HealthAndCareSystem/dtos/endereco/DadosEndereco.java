package com.system.care.health.HealthAndCareSystem.dtos.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosEndereco {
    String rua;
    String bairro;
    String cep;
    String cidade;
    String numero;
    String complemento;
    String estado;

    public DadosEndereco(String street) {
        this.rua = rua;
    }
}
package com.system.care.health.HealthAndCareSystem.models;

import com.system.care.health.HealthAndCareSystem.dtos.doctor.DadosCadastroMedico;
import com.system.care.health.HealthAndCareSystem.enums.EspecialidadeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_MEDICO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String senha;

    private String email;

    private String crm;

    private Boolean ativo = true;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidade")
    private EspecialidadeEnum especialidade;

    private String numeroTelefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "medico")
    public List<Consulta> consultas;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.getNome();
        this.senha = dados.getSenha();
        this.email = dados.getEmail();
        this.numeroTelefone = dados.getNumeroTelefone();
        this.crm = dados.getCrm();
        this.especialidade = dados.getEspecialidade();
        this.endereco = new Endereco(dados.getEndereco());
    }

    public void excluir(){
        this.ativo= false;
    }

}
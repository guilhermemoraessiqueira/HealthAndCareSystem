package com.system.care.health.HealthAndCareSystem.models;

import com.system.care.health.HealthAndCareSystem.dtos.medico.DadosCadastroMedico;
import com.system.care.health.HealthAndCareSystem.enums.EspecialidadeEnum;
import com.system.care.health.HealthAndCareSystem.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "TB_MEDICO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico implements UserDetails {
    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String senha;

    private String email;

    private String crm;

    private Boolean ativo = true;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_MEDICO"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
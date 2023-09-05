package com.system.care.health.HealthAndCareSystem.models;

import com.system.care.health.HealthAndCareSystem.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity(name = "Paciente")
@Table(name = "TB_PACIENTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String senha;

    private String cpf;

    private String email;

    private String numeroTelefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
}
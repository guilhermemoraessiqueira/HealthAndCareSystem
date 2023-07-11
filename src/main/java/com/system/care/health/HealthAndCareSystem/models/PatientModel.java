package com.system.care.health.HealthAndCareSystem.models;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity(name = "Patient")
@Table(name = "TB_PATIENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idPatient")
public class PatientModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPatient;
    private String name;
    private String password;
    private String cpf;
    private String email;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressModel address;
}
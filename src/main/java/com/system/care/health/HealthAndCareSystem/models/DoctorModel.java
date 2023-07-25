package com.system.care.health.HealthAndCareSystem.models;

import com.system.care.health.HealthAndCareSystem.Specialty;
import com.system.care.health.HealthAndCareSystem.dtos.doctor.DoctorRegisterDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity(name = "Doctor")
@Table(name = "TB_DOCTOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idDoctor")
public class DoctorModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoctor;
    private String name;
    private String password;
    private String email;
    private String crm;
    private Boolean active = true;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressModel address;

    public DoctorModel(DoctorRegisterDTO dados) {
        this.active = true;
        this.name = dados.getName();
        this.password = dados.getPassword();
        this.email = dados.getEmail();
        this.phoneNumber = dados.getPhoneNumber();
        this.crm = dados.getCrm();
        this.specialty = dados.getSpecialty();
        this.address = new AddressModel(dados.getAddress());
    }

    public void excluir(){
        this.active= false;
    }
}
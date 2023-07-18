package com.system.care.health.HealthAndCareSystem.models;

import com.system.care.health.HealthAndCareSystem.Specialty;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDoctor;
    private String name;
    private String password;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    private String phoneNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressModel address;

}

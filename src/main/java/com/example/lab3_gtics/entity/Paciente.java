package com.example.lab3_gtics.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.print.Doc;

@Entity
@Getter
@Setter
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String nombre;

    private String edad;

    private String genero;

    private String diagnostico;

    @Column(name = "fecha_cita")
    private String fecha_cita;

    private int numero_habitacion;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    Hospital hospital;


}

package com.example.lab3_gtics.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nombre;

    String edad;

    String genero;

    @Column(name = "fecha_cita")
    String fecha_cita;

    int numero_habitacion;

    @Column(name = "doctor_id")
    int doctor_id;

    @Column(name = "hospital_id")
    int hospital_id;


}

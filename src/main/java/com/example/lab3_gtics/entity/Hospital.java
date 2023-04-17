package com.example.lab3_gtics.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nombre;

    String direccion;

    String telefono;

    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctorList = new ArrayList<>();

    @OneToMany(mappedBy = "hospital")
    private List<Paciente> pacienteList = new ArrayList<>();

}

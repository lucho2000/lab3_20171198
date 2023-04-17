package com.example.lab3_gtics.controllers;


import com.example.lab3_gtics.entity.Doctor;
import com.example.lab3_gtics.entity.Hospital;
import com.example.lab3_gtics.entity.Paciente;
import com.example.lab3_gtics.repositories.DoctorRepository;
import com.example.lab3_gtics.repositories.HospitalRepository;
import com.example.lab3_gtics.repositories.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller

@RequestMapping("/doctor")
public class DoctorController {

    final DoctorRepository doctorRepository;

    final HospitalRepository hospitalRepository;
    final PacienteRepository pacienteRepository;



    public DoctorController(DoctorRepository doctorRepository, HospitalRepository hospitalRepository, PacienteRepository pacienteRepository) {
        this.doctorRepository = doctorRepository;
        this.hospitalRepository = hospitalRepository;
        this.pacienteRepository = pacienteRepository;
    }






    //para la tabla de doctores
    @GetMapping("/listar")
    public String listar(Model model, Integer hospitalId, String nombre) {

        model.addAttribute("lista", doctorRepository.findAll()); //"query" que lista todos los datos de la BD

        //model.addAttribute("lista1", doctorRepository.(hospitalId, nombre));

        /*Optional<Hospital> optHos = hospitalRepository.findById(hospitalId);
        Hospital h = optHos.get();
        model.addAttribute("hospital",h);*/

        //System.out.println((doctorRepository.findDoctorByHospitalid(idHospital)));
        return "doctor/listadoctores";
    }


    //para crear nuevo doctor
    //@GetMapping("/nuevo")
    //public String nuevo() {
        //return "doctor/nuevodoctor";
    //}

    //al crear un nuevo doctor, necesitamos que se guarde (registrar) el objeto doctor
    @PostMapping("/guardar")
    public String guardar(Doctor doctor) {
        doctorRepository.save(doctor);

        return "redirect:/listar";
    }

    @GetMapping("/pacientes")
    public String mostrarPacientes(Model model,Integer idDoctor){

        model.addAttribute("lista", doctorRepository.findById(idDoctor).get());


        //Optional<Paciente> optPac = pacienteRepository.findAllById(idPaciente);

        return "doctor/listapacientes";

    }

    @GetMapping("/proximas")
    public String proximasCitas(Model model, Integer idDoctor){
        LocalDate fechaHoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = fechaHoy.format(formatter);
        //model.addAttribute("lista", doctorRepository.findById(idDoctor).get());
        model.addAttribute("pacientes",pacienteRepository.proximaCita(idDoctor));

        return "doctor/proximascitas";
    }


}

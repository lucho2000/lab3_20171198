package com.example.lab3_gtics.controllers;

import com.example.lab3_gtics.entity.Hospital;
import com.example.lab3_gtics.repositories.HospitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

@RequestMapping("/hospital")
public class HospitalController {

    final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping(value = "/listar")
    public String listar(Model model) {

        model.addAttribute("lista", hospitalRepository.findAll());
        return "hospital/listahospital";
    }

    //@GetMapping("/nuevo")
    /*public String nuevo() {
        return "hospital/nuevohospital";
    }*/

    @PostMapping("/guardar")
    public String guardar(Hospital hospital) {
        hospitalRepository.save(hospital);


        return "redirect:/listar";
    }


    @GetMapping("/doctores")
    public String mostrarDoctores(Model model,Integer idHospital){
        model.addAttribute("listaDoc", hospitalRepository.findById(idHospital).get());
        //Optional<Paciente> optPac = pacienteRepository.findAllById(idPaciente);

        return "hospital/doctores";

    }


    @GetMapping("/pacientes")
    public String mostrarPacientes(Model model,Integer idHospital){
        model.addAttribute("listaPac", hospitalRepository.findById(idHospital).get());
        //Optional<Paciente> optPac = pacienteRepository.findAllById(idPaciente);

        return "hospital/pacientes";

    }



}

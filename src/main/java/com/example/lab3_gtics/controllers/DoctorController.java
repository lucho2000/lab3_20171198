package com.example.lab3_gtics.controllers;


import com.example.lab3_gtics.entity.Doctor;
import com.example.lab3_gtics.entity.Hospital;
import com.example.lab3_gtics.repositories.DoctorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/doctor")
public class DoctorController {

    final DoctorRepository doctorRepository;


    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @GetMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("lista", doctorRepository.findAll());
        return "hospital/listadoctores";
    }

    @GetMapping("/nuevo")
    public String nuevo() {
        return "hospital/nuevodoctor";
    }

    @PostMapping("/guardar")
    public String guardar(Doctor doctor) {
        doctorRepository.save(doctor);

        return "redirect:/listar";
    }
}

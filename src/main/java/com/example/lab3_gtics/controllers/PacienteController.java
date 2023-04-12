package com.example.lab3_gtics.controllers;


import com.example.lab3_gtics.entity.Hospital;
import com.example.lab3_gtics.repositories.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }


    @GetMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("lista", pacienteRepository.findAll());
        return "hospital/listapacientes";
    }

    @GetMapping("/nuevo")
    public String nuevo() {
        return "hospital/nuevohospital";
    }

    @PostMapping("/guardar")
    public String guardar(Hospital hospital) {
        pacienteRepository.save(hospital);


        return "redirect:/listar";
    }
}

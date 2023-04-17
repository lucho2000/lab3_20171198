package com.example.lab3_gtics.controllers;


import com.example.lab3_gtics.entity.Paciente;
import com.example.lab3_gtics.repositories.DoctorRepository;
import com.example.lab3_gtics.repositories.PacienteRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    final PacienteRepository pacienteRepository;
    final DoctorRepository doctorRepository;

    public PacienteController(PacienteRepository pacienteRepository, DoctorRepository doctorRepository) {
        this.pacienteRepository = pacienteRepository;
        this.doctorRepository = doctorRepository;
    }


    @GetMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("lista", pacienteRepository.findAll());
        return "paciente/listapacientes";
    }

    @GetMapping("/nuevo")
    public String nuevo() {
        return "paciente/nuevopaciente";
    }

    @PostMapping("/guardar")
    public String guardarEditado(@RequestParam("id")Integer idPac, @RequestParam("habitacion") Integer num) {
        pacienteRepository.actualizarPacientes(idPac, num); //llamamos al metodo para actualizar el registro

        return "redirect:/paciente/listar";
    }

    @GetMapping("/editar")
    public String editarPaciente(Model model,
                                      @RequestParam("id") int id) {

        Optional<Paciente> optPac = pacienteRepository.findById(id);

        if (optPac.isPresent()) {
            Paciente paciente = optPac.get();
            model.addAttribute("paciente", paciente);
            return "paciente/editarpaciente";
        } else {
            return "redirect:/paciente/listar";
        }
    }



    @GetMapping("/derivar")
    public String derivarPaciente(Model model, Integer id){

        model.addAttribute("listaDoc", doctorRepository.findAll());
        model.addAttribute("paciente", pacienteRepository.findById(id).get());
        return "/paciente/derivarpaciente";

    }

    @PostMapping("/guardarDerivado")
    public String guardarDerivado(@RequestParam("id")Integer id, @RequestParam("id2") Integer id2) {
        pacienteRepository.derivarPacientes(id, id2); //llamamos al metodo para actualizar el registro

        return "redirect:/paciente/listar";
    }
}

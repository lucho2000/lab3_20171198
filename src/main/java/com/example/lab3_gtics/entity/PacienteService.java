package com.example.lab3_gtics.entity;

import com.example.lab3_gtics.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PacienteService {


    //@Autowired
    final PacienteRepository patientRepository;

    public PacienteService(PacienteRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void updatePatientRoomNumber(Integer id, Integer roomNumber) throws Exception {
            Optional<Paciente> optionalPatient = patientRepository.findById(id);
            if (optionalPatient.isPresent()) {
                Paciente paciente = optionalPatient.get();
                paciente.setNumero_habitacion(roomNumber);
                patientRepository.flush();
            } else {
                throw new Exception("Patient with id " + id + " not found.");
            }
        }

}

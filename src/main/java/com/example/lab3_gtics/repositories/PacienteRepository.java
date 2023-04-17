package com.example.lab3_gtics.repositories;


import com.example.lab3_gtics.entity.Paciente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

    //para obtener las proximas citas del doctor, con la fecha actual
    @Query(value = "SELECT * FROM hospital_db.paciente where doctor_id=?1 and fecha_cita > curdate()", nativeQuery = true)
    List<Paciente> proximaCita(Integer idDoc);


    //editar el paciente sin el "save"
    @Modifying
    @Transactional
    @Query(value = "update paciente set numero_habitacion=?2 where id=?1 ", nativeQuery = true)

    void actualizarPacientes(Integer id, Integer numeroHabitacion);


    @Modifying
    @Transactional
    @Query( value = "update paciente set doctor_id = ?2 where doctor_id = ?1",nativeQuery = true)
    void derivarPacientes(Integer id1, Integer id2);

}

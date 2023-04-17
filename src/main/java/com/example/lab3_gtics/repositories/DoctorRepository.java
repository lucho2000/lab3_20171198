package com.example.lab3_gtics.repositories;


import com.example.lab3_gtics.entity.Doctor;
import com.example.lab3_gtics.entity.Hospital;
import jakarta.persistence.ManyToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    //Hospital hospital = new Hospital();

    //@ManyToOne()
    //@Query(value = "SELECT d.id, d.nombre, d.especialidad, h.nombre as 'nombre hospital' FROM hospital_db.doctor d inner join hospital h where d.hospital_id = h.id",nativeQuery = true)
    //List<Doctor> listarDoctorConNombreHospital();

    //List<Doctor> findAllByHospitalidAndNombre(int idHospital, String nombre);
    //List<Doctor> findHospitalByHospitalid(int hospitalid);

    //List<Doctor> getDoctorByHospitalid(int hospitalid);



}

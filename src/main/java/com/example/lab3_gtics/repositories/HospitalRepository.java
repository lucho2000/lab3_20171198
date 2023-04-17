package com.example.lab3_gtics.repositories;


import com.example.lab3_gtics.entity.Hospital;
import com.example.lab3_gtics.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {




}

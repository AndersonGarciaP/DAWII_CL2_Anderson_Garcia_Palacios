package com.example.cibertec.pregunta1y2.Repository;

import com.example.cibertec.pregunta1y2.model.bd.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String> {

}

package com.example.cibertec.pregunta1y2.Service;

import com.example.cibertec.pregunta1y2.Repository.AlumnoRepository;
import com.example.cibertec.pregunta1y2.model.bd.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> listarAlumnos(){
        return alumnoRepository.findAll();
    }
    public void registrarAlumno(Alumno alumno){
        alumnoRepository.save(alumno);
    }
    public void eliminarAlumno(String idalumno){
        alumnoRepository.deleteById(idalumno);
    }
}

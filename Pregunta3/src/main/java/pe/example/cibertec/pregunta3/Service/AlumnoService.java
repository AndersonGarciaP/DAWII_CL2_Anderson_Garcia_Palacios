package pe.example.cibertec.pregunta3.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.example.cibertec.pregunta3.Model.Alumno;
import pe.example.cibertec.pregunta3.Repository.AlumnoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> listarAlumnos(){
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> buscarAlumnoxId(String id) {
        Optional<Alumno> alumno = alumnoRepository.findById(String.valueOf(id));

        if (alumno.isEmpty()) {
            return Optional.empty();
        } else {
            return alumno;
        }
    }
    public Alumno registrar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }
    public HashMap<String, String> eliminarxId(String id) {
        HashMap<String, String> respuesta = new HashMap<String, String>();

        alumnoRepository.deleteById(String.valueOf(id));
        respuesta.put("message", "Eliminado correctamente");
        return respuesta;
    }
}
